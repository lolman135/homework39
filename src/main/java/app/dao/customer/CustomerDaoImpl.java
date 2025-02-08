package app.dao.customer;

import app.dto.customer.request.CustomerDtoRequest;
import app.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("CustomerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

    //TODO implements all method (normally)

    @Override
    public boolean create(CustomerDtoRequest request) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Optional<List<Customer>> fetchAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> fetchById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean updateById(Long id, CustomerDtoRequest request) {
        return false;
    }

    @Override
    public Optional<Customer> getLastEntity() {
        return Optional.empty();
    }
}
