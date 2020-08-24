
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Customer;
import com.util.DBConnection;

public class loginDAOImpl implements loginDAO {

	@Override
	public Customer login(int Customer_id, String password) {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from login where customer_id=? and password=?");
			stmt.setInt(1, Customer_id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CustomerDAO dao = new CustomerDAOImpl();
				customer = dao.getCustomerByID(Customer_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

}
