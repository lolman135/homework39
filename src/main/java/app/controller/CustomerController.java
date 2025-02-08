package app.controller;

import app.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //TODO create basic CRUD method (post, get, put, delete)
}
