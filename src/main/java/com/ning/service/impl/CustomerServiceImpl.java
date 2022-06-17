package com.ning.service.impl;

import com.ning.dao.CustomerMapper;
import com.ning.entity.Customer;
import com.ning.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    public CustomerMapper getCustomerMapper() {
        return customerMapper;
    }

    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public int deleteCustomer(Customer customer) {
        return customerMapper.deleteCustomer(customer);
    }

    @Override
    public Customer queryById(String customerId) {
        return customerMapper.queryById(customerId);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public List<Customer> queryAll() {
        return customerMapper.queryAll();
    }

    @Override
    public List<Customer> queryByName(String name) {
        return customerMapper.queryByName(name);
    }
}
