package com.allegro.trade.services;

import java.util.List;
import com.allegro.trade.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    List<Customer> listAllCustomers();
    Customer getCustomerById(Integer id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
