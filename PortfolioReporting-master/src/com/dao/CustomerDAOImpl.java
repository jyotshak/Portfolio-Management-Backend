package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Customer;
import com.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer getCustomerByID(int customerID) {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from customer where customer_id=?");
			stmt.setInt(1, customerID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomer_id(rs.getInt("customer_id"));
				customer.setFullname(rs.getString("full_name"));
				customer.setDate_of_birth(rs.getDate("date_of_birth"));
				customer.setPlace_of_birth(rs.getString("place_of_birth"));
				customer.setGender(rs.getString("gender"));
				customer.setNationality(rs.getString("nationality"));
				customer.setAddress(rs.getString("address"));
				customer.setMobileNo(rs.getString("mobile_no"));
				customer.setAdhar_no(rs.getString("adhar_no"));
				customer.setPan_no(rs.getString("pan_no"));
				customer.setAccount_no(rs.getString("account_no"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(int customerID, Customer c) {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"UPDATE customer SET FULL_NAME=?,DATE_OF_BIRTH=?,PLACE_OF_BIRTH=?,GENDER=?,NATIONALITY=?,ADDRESS=?,MOBILE_NO=?,ADHAR_NO=?,PAN_NO=?,ACCOUNT_NO=? where customer_id=?");
			stmt.setString(1, c.getFullname());
			stmt.setDate(2, (Date) c.getDate_of_birth());
			stmt.setString(3, c.getPlace_of_birth());
			stmt.setString(4, c.getGender());
			stmt.setString(5, c.getNationality());
			stmt.setString(6, c.getAddress());
			stmt.setString(7, c.getMobileNo());
			stmt.setString(8, c.getAdhar_no());
			stmt.setString(9, c.getPan_no());
			stmt.setString(10, c.getAccount_no());
			stmt.setInt(11, customerID);


			ResultSet rs = stmt.executeQuery();

			customer = getCustomerByID(customerID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		Customer customer = getCustomerByID(customerID);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from customer where customer_id=?");
			stmt.setInt(1, customerID);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, c.getCustomer_id());
			stmt.setString(2, c.getFullname());
			stmt.setDate(3, (Date) c.getDate_of_birth());
			stmt.setString(4, c.getPlace_of_birth());
			stmt.setString(5, c.getGender());
			stmt.setString(6, c.getNationality());
			stmt.setString(7, c.getAddress());
			stmt.setString(8, c.getMobileNo());
			stmt.setString(9, c.getAdhar_no());
			stmt.setString(10, c.getPan_no());
			stmt.setString(11, c.getAccount_no());

			ResultSet rs = stmt.executeQuery();
			customer = getCustomerByID(c.getCustomer_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
}
