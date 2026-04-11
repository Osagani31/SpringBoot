package com.osagani.app.service;

import com.osagani.app.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAllCustomers();
    public void saveCustomer(Customer customer);
    public Customer findCustomer(long id);
    public void deleteCustomer(long id);
}