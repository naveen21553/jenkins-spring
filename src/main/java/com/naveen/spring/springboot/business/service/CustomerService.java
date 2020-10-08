package com.naveen.spring.springboot.business.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.naveen.spring.springboot.business.Exceptions.ResourceNotFoundException;
import com.naveen.spring.springboot.data.entity.Customer;
import com.naveen.spring.springboot.data.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);        
    }

    public List<Customer> getAllCustomer(){
        return (List<Customer>)this.customerRepository.findAll();
    }

    public Customer getCustomerByCno(long cno){
        Optional<Customer> c = this.customerRepository.findById(cno);
        if (c.isPresent()){
            return c.get();
        }
        else throw new ResourceNotFoundException("Record not found for customer no: " + cno);
    }

    public Customer updateCustomer(long customerNo, Customer customer){
        Optional<Customer> c = this.customerRepository.findById(customerNo);
        if (c.isPresent()){
            Customer cUpdate = c.get();
            cUpdate.setCustomerNo(customer.getCustomerNo());
            cUpdate.setName(customer.getName());
            cUpdate.setAccountNo(customer.getAccountNo());
            customerRepository.save(cUpdate);
            return cUpdate;

        }
        else throw new ResourceNotFoundException("Record not found for customer no: " + customerNo);

    }

    public HttpStatus deleteCustomer(long cno){
        Optional<Customer> c = this.customerRepository.findById(cno);
        if (c.isPresent()){
            this.customerRepository.delete(c.get());
            return HttpStatus.OK;
        }
        else throw new ResourceNotFoundException("Record not found for customer no: " + cno);
    }
}
