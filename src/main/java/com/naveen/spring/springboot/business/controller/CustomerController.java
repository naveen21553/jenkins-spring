package com.naveen.spring.springboot.business.controller;

import java.util.List;

import com.naveen.spring.springboot.business.service.CustomerService;
import com.naveen.spring.springboot.data.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
   
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }

    @GetMapping("/customers/{cno}")
    public ResponseEntity<Customer> getCustomerByCno(@PathVariable long cno){
        return ResponseEntity.ok().body(this.customerService.getCustomerByCno(cno));
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
    }

    @PutMapping("/customers/{cno}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long cno, @RequestBody Customer customer){
        return ResponseEntity.ok().body(this.customerService.updateCustomer(cno, customer));
    }

    @DeleteMapping("/customers/{cno}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long cno){
        this.customerService.deleteCustomer(cno);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);

    }
}
