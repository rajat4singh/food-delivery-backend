package com.fooddelivery.backend.app.Controller;

import com.fooddelivery.backend.app.dto.requestDTOs.CustomerRequest;
import com.fooddelivery.backend.app.dto.responseDTOs.CustomerResponse;
import com.fooddelivery.backend.app.exceptions.CustomerNotFoundException;
import com.fooddelivery.backend.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/add")

    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse= customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    //get customer by mobileNo
    @GetMapping("/get-by-mob-no")
    public ResponseEntity getCustomerByMobileNumber(@RequestParam String mob){
        try {
            CustomerResponse customerResponse = customerService.getCustomerByMobileNumber(mob);
            return new ResponseEntity(customerResponse, HttpStatus.FOUND);
        }
        catch (CustomerNotFoundException e){
            String response =e.getMessage();
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

    // get the customer with most number of orders

    @GetMapping("/get-customer-with-most-orders")
    public ResponseEntity getCustomerWithMostOrders(){
        try {
            CustomerResponse customerResponse = customerService.getCustomerWithMostOrders();
            return new ResponseEntity(customerResponse, HttpStatus.FOUND);
        }
        catch(CustomerNotFoundException e){
            String response= e.getMessage();
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

    // get the female customer with least number of orders
    @GetMapping("/get-customer-with-least-orders")
    public ResponseEntity getCustomerWithLeastOrders(){
        try {
            CustomerResponse customerResponse = customerService.getCustomerWithLeastOrders();
            return new ResponseEntity(customerResponse, HttpStatus.FOUND);
        }
        catch(CustomerNotFoundException e){
            String response= e.getMessage();
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }


}
