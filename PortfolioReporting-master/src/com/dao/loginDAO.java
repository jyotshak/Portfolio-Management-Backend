package com.dao;

import com.pojo.Customer;

public interface loginDAO {
	public Customer login(int Customer_id,String password);
}
