package com.allegro.trade.services;

import com.allegro.trade.domain.Customer;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        customers = new HashMap<>();
        loadCustomers();
    }

    private void loadCustomers() {
        for (int i = 1; i < 6; i++) {
            Customer c = new Customer();
            c.setId(i);
            c.setFirstName("Lukasz" + i);
            c.setLastName("Nowak" + i);
            c.setPhoneNumber("48 555 555 555" + i);
            c.setEmail("LukaszNowak@" + i + ".com");
            c.setAddressLineOne("Street " + i);
            c.setAddressLineTwo("Flat " + i);
            c.setCity("Białystok");
            c.setZipCode("00-999");
            c.setState("Main");
            customers.put(i, c);
        }
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
        } else {
            throw new RuntimeException("Can;t be null!");
        }
        return getCustomerById(customer.getId());
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }
}
