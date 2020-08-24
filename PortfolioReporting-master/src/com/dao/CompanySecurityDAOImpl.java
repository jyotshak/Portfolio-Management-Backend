package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.displayAttributes.enrichedCompanySecurity;
import com.displayAttributes.enrichedEquity;
import com.pojo.CompanySecurity;
import com.util.DBConnection;

public class CompanySecurityDAOImpl implements CompanySecurityDAO {

	@Override
	public CompanySecurity getCompanySecurity(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanySecurity updateCompanySecurity(CompanySecurity cs, int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanySecurity deleteCompanySecurity(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanySecurity addCompanySecurity(CompanySecurity cs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<enrichedCompanySecurity> getCompanySecurity() {
		List<enrichedCompanySecurity> list=new ArrayList<>();
		String sql="SELECT TRANSACTION.TRADE_DATE,TRANSACTION.SECURITY_SYMBOL,TRANSACTION.qty_of_traded_sec,PRICE.PRICE FROM TRANSACTION JOIN PRICE ON TRANSACTION.SECURITY_SYMBOL=PRICE.SECURITY_SYMBOL"; 
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enrichedCompanySecurity e=new enrichedCompanySecurity();
				
				e.setPrice(rs.getFloat(4));
				e.setQuantity(rs.getString(3));
				e.setSECURITY_SYMBOL(rs.getString(2));
				e.setTRADE_DATE(rs.getDate(1));
				list.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return list;		
		
	}

}
