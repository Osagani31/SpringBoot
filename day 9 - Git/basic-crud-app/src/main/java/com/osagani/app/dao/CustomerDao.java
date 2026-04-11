package com.osagani.app.dao;

import com.osagani.app.entity.Customer;

import java.util.List;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findAllCustomers();
    public void saveCustomer(Customer customer);
    public Customer findCustomer(long id);
    public void deleteCustomer(long id);
}