package com.dao;

import com.pojo.Security;

public interface SecurityDAO {

	public Security getSecurityBySecuritySymbol(String SecuritySymbol);
	public Security deleteSecurity(String SecuritySymbol);
	public Security addSecurity(Security s);
	public Security updateSecurity(Security security, String SecuritySymbol);

}
