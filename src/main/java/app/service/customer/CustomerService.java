package app.service.customer;

import app.dto.customer.request.CustomerDtoRequest;
import app.entity.Customer;
import app.service.BaseService;

import java.util.List;

public interface CustomerService extends BaseService<Customer, CustomerDtoRequest> {

    @Override
    Customer create(CustomerDtoRequest request);

    @Override
    boolean deleteById(Long id);

    @Override
    List<Customer> fetchAll();

    @Override
    Customer fetchById(Long id);

    @Override
    Customer updateById(Long id, CustomerDtoRequest request);
}
