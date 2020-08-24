package com.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.displayAttributes.enrichedoptions;
import com.pojo.Bond;
import com.pojo.Options;
import com.pojo.Security;
import com.util.DBConnection;

public class OptionsDAOImpl implements OptionsDAO {

	@Override
	public Options getOptions(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Options o = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from options where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				o = new Options();
				o.setSecuritySymbol(rs.getString(1));
				o.setStrikePrice(rs.getFloat(2	)); 
				o.setExpirationDate(rs.getDate(3));
				o.setPremium(rs.getFloat(4));
				o.setLotSize(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public Options updateOptions(Options o, String SecuritySymbol) {
		// TODO Auto-generated method stub
		Options options = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"UPDATE options SET strike_price=?, expiration_date=?, premium=?, lot_size=? where security_symbol=?");
			stmt.setFloat(1, o.getStrikePrice());
			stmt.setDate(2, (java.sql.Date) o.getExpirationDate());
			stmt.setFloat(3, o.getPremium());
			stmt.setInt(4, o.getLotSize());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				options= getOptions(SecuritySymbol);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return options;
	}

	@Override
	public Options deleteOptions( String SecuritySymbol) {
		// TODO Auto-generated method stub
		Options options = getOptions(SecuritySymbol);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from options where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return options;
	}

	@Override
	public Options addOptions(Options o, Security s) {
		// TODO Auto-generated method stub
		Options options = null;
		SecurityDAO dao = new SecurityDAOImpl();
		dao.addSecurity(s);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into options values(?,?,?,?,?)");
			stmt.setString(1, o.getSecuritySymbol());
			stmt.setFloat(2, o.getStrikePrice());
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Date date =  o.getExpirationDate();
			Instant instant = date.toInstant();
			LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
			System.out.println(localDate);
			stmt.setDate(3, java.sql.Date.valueOf(localDate));
			//			stmt.setDate(3, (Date) o.getExpirationDate());
			stmt.setFloat(4, o.getPremium());
			stmt.setInt(5, o.getLotSize());
			ResultSet rs = stmt.executeQuery();
			options = getOptions(o.getSecuritySymbol());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	@Override
	public List<enrichedoptions> getOptions(int customer_id) {
		List<enrichedoptions> l=new ArrayList<>();
		String sql="select options.security_symbol,strike_price,expiration_date,premium,lot_size,trade_date,qty_of_traded_sec from options join transaction on transaction.security_symbol=options.security_symbol where transaction.customer_id=?";
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, customer_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enrichedoptions e=new enrichedoptions();
				e.setExpirationDate(rs.getDate(3));
				e.setLotSize(rs.getInt(5));
				e.setPremium(rs.getFloat(4));
				e.setQuantity(rs.getInt(7));
				e.setStrikePrice(rs.getFloat(2));
				e.setTrade_date(rs.getDate(6));
				e.setSecurity_symbol(rs.getString(1));
				l.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	
	
	}

}
