package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pojo.Bond;
import com.pojo.Price;
import com.pojo.Security;
import com.util.DBConnection;

public class PriceDAOImpl implements PriceDAO {

	@Override
	public List<Price> getPriceList(String SecuritySymbol) {
		// TODO Auto-generated method stub
		List<Price> list = new ArrayList<Price>();
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from price where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Price p = new Price();
				p.setPrice(rs.getFloat(1));
				p.setTradeDate(rs.getDate(2));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Price updatePrice(Price p, String SecuritySymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Price deletePrice(Price p, String SecuritySymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Price addPrice(Price p, String SecuritySymbol) {
		// TODO Auto-generated method stub
		Price price = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into price values(?,?,?)");
			stmt.setFloat(1, p.getPrice());
			stmt.setDate(2, (java.sql.Date) p.getTradeDate());
			stmt.setString(3, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return price;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return price;
	}

	@Override
	public Price getPriceByDate(String SecuritySymbol, Date date) {
		// TODO Auto-generated method stub
		Price p = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from price where security_symbol=? and trade_date=?");
			stmt.setString(1, SecuritySymbol);
			stmt.setDate(2, (java.sql.Date) date);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Price();
				p.setPrice(rs.getFloat(1));
				p.setTradeDate(rs.getDate(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return p;
	}

}
