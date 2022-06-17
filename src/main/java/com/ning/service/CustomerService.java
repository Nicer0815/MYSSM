package com.ning.service;

import com.ning.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    int addCustomer(Customer customer);
    int deleteCustomer(Customer customer);
    Customer queryById(String customerId);
    int updateCustomer(Customer customer);
    List<Customer> queryAll();

    List<Customer> queryByName(String name);
}
