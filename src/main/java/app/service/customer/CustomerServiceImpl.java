package app.service.customer;

import app.dao.customer.CustomerDao;
import app.dto.customer.request.CustomerDtoRequest;
import app.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer create(CustomerDtoRequest request) {
        customerDao.create(request);
        return customerDao.getLastEntity().orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (customerDao.fetchById(id).isPresent()){
            customerDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> fetchAll() {
        return customerDao.fetchAll().orElse(Collections.emptyList());
    }

    @Override
    public Customer fetchById(Long id) {
        return customerDao.fetchById(id).orElse(null);
    }

    @Override
    public Customer updateById(Long id, CustomerDtoRequest request) {
        if (id == null){
            throw new IllegalArgumentException("Id must be not null!");
        }

        if (customerDao.fetchById(id).isPresent()){
            customerDao.updateById(id, request);
        }

        return customerDao.fetchById(id).orElse(null);
    }
}
