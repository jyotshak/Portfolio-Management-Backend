package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.displayAttributes.enrichedBonds;
import com.displayAttributes.enrichedEquity;
import com.pojo.Bond;
import com.pojo.Security;
import com.util.DBConnection;

public class BondDAOImpl implements BondDAO {

	@Override
	public Bond getBond(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Bond b = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from bond where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				b = new Bond();
				b.setSecuritySymbol(rs.getString(1));
				b.setFaceValue(rs.getFloat(2));
				b.setCouponRate(rs.getFloat(3));
				b.setFrequencyOfPayment(rs.getFloat(4));
				b.setMaturity(rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Bond updateBond(Bond b, String SecuritySymbol) {
		// TODO Auto-generated method stub
		Bond bond = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"UPDATE bond SET face_value=?, coupon_rate=?, frequency_of_payment=?, maturity=? where security_symbol=?");
			stmt.setFloat(1, b.getFaceValue());
			stmt.setFloat(2, b.getCouponRate());
			stmt.setFloat(3, b.getFrequencyOfPayment());
			stmt.setDate(4, (Date) b.getMaturity());
			stmt.setString(5, b.getSecuritySymbol());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				b = getBond(SecuritySymbol);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bond;
	}

	@Override
	public Bond deleteBond(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Bond bond = getBond(SecuritySymbol);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from bond where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bond;

	}

	@Override
	public Bond addBond(Bond b, Security s) {
		// TODO Auto-generated method stub
		Bond bond = null;
		SecurityDAO dao = new SecurityDAOImpl();
		dao.addSecurity(s);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into bond values(?,?,?,?,?)");
			stmt.setString(1, b.getSecuritySymbol());
			stmt.setFloat(2, b.getFaceValue());
			stmt.setFloat(3, b.getCouponRate());
			stmt.setFloat(4, b.getFrequencyOfPayment());
			stmt.setDate(5, (Date) b.getMaturity());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bond = getBond(b.getSecuritySymbol());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public List<enrichedBonds> getBond(int customerId) {
		// TODO Auto-generated method stub
		String sql="select bond.security_symbol,face_value,coupon_rate,frequency_of_payment,maturity,trade_date,qty_of_traded_sec from bond join transaction on bond.security_symbol=transaction.security_symbol where customer_id=?";
		List<enrichedBonds> list=new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enrichedBonds e=new enrichedBonds();
				
				e.setCouponRate(rs.getFloat(3));
				e.setFaceValue(rs.getFloat(2));
				e.setFrequency(rs.getFloat(4));
				e.setMaturity(rs.getDate(5));
				e.setQuantity(rs.getInt(7));
				e.setSecurity_symbol(rs.getString(1));
				e.setTrade_date(rs.getDate(6));
				list.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return list;
		
	}

}
