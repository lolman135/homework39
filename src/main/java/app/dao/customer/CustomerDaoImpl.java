package app.dao.customer;

import app.dto.customer.request.CustomerDtoRequest;
import app.entity.Customer;
import app.entity.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository("CustomerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

    NamedParameterJdbcTemplate template;

    @Autowired
    public CustomerDaoImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(CustomerDtoRequest request) {
        String sql = "INSERT INTO customers (full_name, email, social_security_number) " +
                "VALUES (:firstName, :email, :socialSecurityNumber);";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("fullName", request.fullName())
                .addValue("email", request.email())
                .addValue("socialSecurityNumber", request.socialSecurityNumber());
        return template.update(sql, parameterSource) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM customers WHERE id = :id;";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id);
        return template.update(sql, parameterSource) > 0;
    }

    @Override
    public Optional<List<Customer>> fetchAll() {
        String sql = "SELECT * FROM customers;";

        Optional<List<Customer>> customers;

        try{
            customers = Optional.of(template.query(sql, new CustomerMapper()));
        } catch (Exception e){
            customers = Optional.empty();
        }

        return customers;
    }

    @Override
    public Optional<Customer> fetchById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = :id LIMIT 1;";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        Optional<Customer> customer;

        try{
            customer = Optional.of(template.queryForObject(sql, parameterSource, new CustomerMapper()));
        } catch (Exception e){
            customer = Optional.empty();
        }

        return customer;
    }

    @Override
    public boolean updateById(Long id, CustomerDtoRequest request) {
        String sql = "UPDATE customers " +
                "SET full_name = :fullName, email = :email, social_security_number = :socialSecurityNumber " +
                "WHERE id = :id;";

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("fullName", request.fullName())
                .addValue("email", request.email())
                .addValue("socialSecurityNumber", request.socialSecurityNumber())
                .addValue("id", id);

        return template.update(sql, parameterSource) > 0;
    }

    @Override
    public Optional<Customer> getLastEntity() {

        String sql = "SELECT * FROM customers ORDER DESC LIMIT 1";
        SqlParameterSource parameterSource = new MapSqlParameterSource();
        Optional<Customer> customer;

        try{
            customer = Optional.of(template.queryForObject(sql, parameterSource, new CustomerMapper()));
        } catch (Exception e){
            customer = Optional.empty();
        }
        return customer;
    }
}
