package app.dao.customer;

import app.dao.BaseDao;
import app.dto.customer.request.CustomerDtoRequest;
import app.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao extends BaseDao<Customer, CustomerDtoRequest> {

    @Override
    boolean create(CustomerDtoRequest request);

    @Override
    boolean deleteById(Long id);

    @Override
    Optional<List<Customer>> fetchAll();

    @Override
    Optional<Customer> fetchById(Long id);

    @Override
    boolean updateById(Long id, CustomerDtoRequest request);

    Optional<Customer> getLastEntity();
}
