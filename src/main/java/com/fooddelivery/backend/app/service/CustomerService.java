package com.fooddelivery.backend.app.service;

import com.fooddelivery.backend.app.Transformer.CustomerTransformer;
import com.fooddelivery.backend.app.dto.requestDTOs.CustomerRequest;
import com.fooddelivery.backend.app.dto.responseDTOs.CustomerResponse;
import com.fooddelivery.backend.app.exceptions.CustomerNotFoundException;
import com.fooddelivery.backend.app.model.Cart;
import com.fooddelivery.backend.app.model.Customer;
import com.fooddelivery.backend.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer= CustomerTransformer.CustomerRequestToCustomer(customerRequest);
        Cart cart= Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);
        Customer savedCustomer= customerRepository.save(customer);
        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomerByMobileNumber(String mob) {
        Optional<Customer> customerOptional= customerRepository.findByMobileNo(mob);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("Incorrect Mobile Number!");
        }
        Customer customer= customerOptional.get();
        return  CustomerTransformer.CustomerToCustomerResponse(customer);
    }

    public CustomerResponse getCustomerWithMostOrders() {
//        List<Customer> customers= customerRepository.findAll();
//        if(customers.isEmpty()){
//            throw new CustomerNotFoundException("No Customers Available in our Database!");
//        }
//        long count=-1;
//        Customer customer=null;
//        for(Customer c: customers){
//            long currCount=c.getOrders().size();
//            if(currCount>count){
//                count=currCount;
//                customer= c;
//            }
//        }
//        return  CustomerTransformer.CustomerToCustomerResponse(customer);

        Optional<Customer> customerOptional= customerRepository.getCustomerWithMostOrders();
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("No Customers Available in our Database!");
        }
        Customer customer=customerOptional.get();
        return  CustomerTransformer.CustomerToCustomerResponse(customer);
    }

    public CustomerResponse getCustomerWithLeastOrders() {

//        List<Customer> customers= customerRepository.findAll();
//        if(customers.isEmpty()){
//            throw new CustomerNotFoundException("No Customers Available in our Database!");
//        }
//        long count=Long.MAX_VALUE;
//        Customer customer=null;
//        for(Customer c: customers){
//            long currCount=c.getOrders().size();
//            if(currCount<count){
//                count=currCount;
//                customer= c;
//            }
//        }
//        return  CustomerTransformer.CustomerToCustomerResponse(customer);

        Optional<Customer> customerOptional= customerRepository.getCustomerWithLeastOrders();
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("No Customers Available in our Database!");
        }
        Customer customer=customerOptional.get();
        return  CustomerTransformer.CustomerToCustomerResponse(customer);
    }
}