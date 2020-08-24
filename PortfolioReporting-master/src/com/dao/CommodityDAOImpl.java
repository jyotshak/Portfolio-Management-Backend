package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.displayAttributes.enrichedCommodity;
import com.displayAttributes.enrichedEquity;
import com.pojo.Bond;
import com.pojo.Commodity;
import com.pojo.Security;
import com.util.DBConnection;

public class CommodityDAOImpl implements CommodityDAO {

	@Override
	public Commodity getCommodity(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Commodity c = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from commodity where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				c = new Commodity();
				c.setSecuritySymbol(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Commodity updateCommodity(Commodity e, String SecuritySymbol) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public Commodity deleteCommodity(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Commodity commodity = getCommodity(SecuritySymbol);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from commodity where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commodity;
	}

	@Override
	public Commodity addCommodity(Commodity c, Security s) {
		// TODO Auto-generated method stub
		Commodity commodity = null;
		SecurityDAO dao = new SecurityDAOImpl();
		dao.addSecurity(s);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into commodity values(?)");
			stmt.setString(1, c.getSecuritySymbol());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				commodity = getCommodity(c.getSecuritySymbol());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public List<enrichedCommodity> getCommodity(int customerId) {
		List<enrichedCommodity> list=new ArrayList<>();
		String sql="select TRANSACTION.TRADE_DATE, TRANSACTION.SECURITY_SYMBOL, TRANSACTION.QTY_OF_TRADED_SEC, PRICE.PRICE\r\n" + 
				"from TRANSACTION  inner join COMMODITY  on\r\n" + 
				"TRANSACTION.SECURITY_SYMBOL = COMMODITY.SECURITY_SYMBOL inner join PRICE  on \r\n" + 
				"PRICE.SECURITY_SYMBOL = COMMODITY.SECURITY_SYMBOL WHERE TRANSACTION.CUSTOMER_ID=?";
	
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enrichedCommodity e=new enrichedCommodity();
				
				
				e.setPrice(rs.getFloat(4));
				e.setQuantityOfTradedSecurity(rs.getInt(3));
				e.setSecuritySymbol(rs.getString(2));
				
				e.setTrade_date(rs.getDate(1));
				
				list.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return list;
	
	}

}
