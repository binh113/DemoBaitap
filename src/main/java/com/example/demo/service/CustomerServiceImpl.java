package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    private static Map<Integer,Customer> customerList;

    static {
        customerList = new HashMap<>();
        customerList.put(1, new Customer(1,"Hai","hai@gmail.com","Binh Thuan",""));
        customerList.put(2, new Customer(2,"Quang","quang@gmail.com","Binh Thuan",""));
        customerList.put(3, new Customer(3,"Linh","Linh@gmail.com","Binh Thuan",""));
        customerList.put(4, new Customer(4,"Binh","Binh@gmail.com","Binh Thuan",""));

    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values()) ;
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> tempList = new ArrayList<>();
        for (Customer c:
             customerList.values()) {
            if (c.getName().contains(name)) {
                tempList.add(c);
            }
        }
        return tempList;
    }

    @Override
    public Customer remove(int id) {
        return customerList.remove(id);
    }

    @Override
    public void edit(Customer customer) {
        customerList.put(customer.getId(),customer);
    }
}
