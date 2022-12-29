package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    List<Customer> findByName(String name);

    Customer remove(int id);

    void edit(Customer customer);
}
