package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Bond;
import com.pojo.Security;
import com.util.DBConnection;

public class SecurityDAOImpl implements SecurityDAO {

	@Override
	public Security getSecurityBySecuritySymbol(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Security s = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from security where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s = new Security();
				s.setSecuritySymbol(rs.getString(1));
				s.setSecurityType(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Security updateSecurity(Security security, String SecuritySymbol) {
		// TODO Auto-generated method stub
		Security s = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(
					"UPDATE security SET security_type=? where security_symbol=?");
			stmt.setString(1, security.getSecurityType());
			stmt.setString(2, SecuritySymbol);
			ResultSet rs = stmt.executeQuery();
			s = getSecurityBySecuritySymbol(SecuritySymbol);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public Security deleteSecurity(String SecuritySymbol) {
		// TODO Auto-generated method stub
		Security s = getSecurityBySecuritySymbol(SecuritySymbol);
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from security where security_symbol=?");
			stmt.setString(1, SecuritySymbol);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Security addSecurity(Security s) {
		// TODO Auto-generated method stub
		Security security = null;
		Connection con = DBConnection.createConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into security values(?,?)");
			stmt.setString(1, s.getSecuritySymbol());
			stmt.setString(2, s.getSecurityType());
			ResultSet rs = stmt.executeQuery();
			security = getSecurityBySecuritySymbol(s.getSecuritySymbol());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return security;
	}

}
