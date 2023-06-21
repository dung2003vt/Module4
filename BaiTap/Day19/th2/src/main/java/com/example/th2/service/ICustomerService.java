package com.example.th2.service;

import com.example.th2.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
