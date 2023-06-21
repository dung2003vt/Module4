package com.example.th2.repository;

import com.example.th2.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
