package com.ning.dao;

import com.ning.entity.Customer;

import java.util.List;

public interface CustomerMapper {
    int addCustomer(Customer customer);
    int deleteCustomer(Customer customer);
    Customer queryById(String customerId);
    int updateCustomer(Customer customer);
    List<Customer> queryAll();
}
