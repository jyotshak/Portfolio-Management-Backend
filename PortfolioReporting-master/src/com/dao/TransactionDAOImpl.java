package com.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.pojo.Options;
import com.pojo.Price;
import com.pojo.Security;
import com.pojo.Transaction;
import com.util.DBConnection;

public class TransactionDAOImpl implements TransactionDAO {

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
	}
	@Override
	public List<Transaction> getTransactionByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		List<Transaction> list = new ArrayList<Transaction>();
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from transaction where customer_id=?");
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Transaction t = new Transaction();
				t.setCustomer_id(rs.getInt(1));
				t.setTrade_date(rs.getDate(2));
				String securitySymbol = rs.getString(3);
				SecurityDAO dao = new SecurityDAOImpl();
				Security s = dao.getSecurityBySecuritySymbol(securitySymbol);
				t.setSecurity(s);
				t.setQuantityOfTradedSecurity(rs.getInt(4));
				t.setTransaction_id(rs.getString(5));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public Transaction updateTransaction(String transactionid, Transaction newtransaction) {
		// TODO Auto-generated method stub
		Transaction t = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"UPDATE transaction SET customer_id=?, trade_date=?, security_symbol=?, qty_of_traded_sec=? where transaction_id=?");
			stmt.setInt(1, newtransaction.getCustomer_id());
//	        ZoneId defaultZoneId = ZoneId.systemDefault();
//			Date date =  newtransaction.getTrade_date();
//	        Instant instant = date.toInstant();
//	        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
			stmt.setDate(2, (java.sql.Date) newtransaction.getTrade_date() );
			Security s = newtransaction.getSecurity();
			stmt.setString(3, s.getSecuritySymbol());
			stmt.setInt(4, newtransaction.getQuantityOfTradedSecurity());
			stmt.setString(5, transactionid);
			ResultSet rs = stmt.executeQuery();
			t = getTransactionByTransactionId(transactionid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	@Override
	public Transaction deleteTransaction(String transactionid) {
		// TODO Auto-generated method stub
		Transaction t = getTransactionByTransactionId(transactionid);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from transaction where transaction_id=?");
			stmt.setString(1, transactionid);
			ResultSet rs = stmt.executeQuery();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub

		System.out.println("Enter**********");
//		System.out.println((Date) transaction.getTrade_date());
		Transaction t =null;
		TransactionDAO dao = new TransactionDAOImpl();
//		dao.addSecurity(s);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into transaction values(?,?,?,?,?)");
			stmt.setInt(1, transaction.getCustomer_id());
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Date date =  transaction.getTrade_date();
	        Instant instant = date.toInstant();
	        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
	        System.out.println(localDate);
			stmt.setDate(2, java.sql.Date.valueOf(localDate));
//			stmt.setDate(2, java.sql.Date.va(transaction.getTrade_date()));
			Security s = transaction.getSecurity();
			stmt.setString(3, s.getSecuritySymbol());
			stmt.setFloat(4, transaction.getQuantityOfTradedSecurity());
			stmt.setString(5, transaction.getTransaction_id());
			ResultSet rs = stmt.executeQuery();
			t = getTransactionByTransactionId(transaction.getTransaction_id());
			System.out.println("one transaction is added");
//			t = dao.getOptions(o.getSecuritySymbol());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	private Date Date(long time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransactionByTransactionId(String  transactionid) {
		Transaction t = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from transaction where transaction_id=?");
			stmt.setString(1, transactionid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				t = new Transaction();
				t.setCustomer_id(rs.getInt(1));
				t.setTrade_date(rs.getDate(2));
				String securitySymbol = rs.getString(3);
				SecurityDAO dao = new SecurityDAOImpl();
				Security s = dao.getSecurityBySecuritySymbol(securitySymbol);
				t.setSecurity(s);
				t.setQuantityOfTradedSecurity(rs.getInt(4));
				t.setTransaction_id(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}
}
