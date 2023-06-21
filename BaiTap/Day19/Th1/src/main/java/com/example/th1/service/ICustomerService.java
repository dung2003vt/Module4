package com.example.th1.service;

import com.example.th1.model.Customer;
import com.example.th1.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
