package app.controller;

import app.dto.customer.request.CustomerDtoRequest;
import app.dto.customer.response.*;
import app.entity.Customer;
import app.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDtoCreateResponse> createUser(@RequestBody CustomerDtoRequest request){
        Customer customer = customerService.create(request);

        return (customer != null)
                ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoCreateResponse.of(true, customer))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoCreateResponse.of(false, null));

    }

    @GetMapping
    public ResponseEntity<CustomerDtoListResponse> fetchAll(){
        List<Customer> customers = customerService.fetchAll();

        return (!customers.isEmpty())
                ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoListResponse.of(false, customers))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoListResponse.of(true, null));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoByIdResponse> fetchById(@PathVariable("id") Long id){
        Customer customer = customerService.fetchById(id);

        return (customer != null)
                ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoByIdResponse.of(id, true, customer))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoByIdResponse.of(id, false, null));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDtoUpdateResponse> updateById(
            @PathVariable("id") Long id,
            @RequestBody CustomerDtoRequest request){
        Customer customer = customerService.updateById(id, request);

        return (customer != null)
                ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoUpdateResponse.of(id,true, customer))
                :
                ResponseEntity.status(HttpStatus.OK)
                        .body(CustomerDtoUpdateResponse.of(id,false, null));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDtoDeleteResponse> deleteById (@PathVariable("id") Long id){
        if (customerService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CustomerDtoDeleteResponse.of(id, true));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CustomerDtoDeleteResponse.of(id, false));
        }
    }
}
