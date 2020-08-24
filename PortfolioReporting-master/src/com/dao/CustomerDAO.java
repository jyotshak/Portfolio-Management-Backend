package com.dao;

import com.pojo.Customer;

public interface CustomerDAO {
public Customer getCustomerByID(int customerID);
public Customer updateCustomer(int customerID,Customer c);
public Customer deleteCustomer(int customerID);
public Customer addCustomer(Customer c);

}
