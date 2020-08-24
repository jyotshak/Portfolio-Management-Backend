package com.dao;

import java.util.List;

import com.displayAttributes.enrichedEquity;
import com.pojo.Equity;
import com.pojo.Security;

public interface EquityDAO {
	public Equity getEquity(String SecuritySymbol);
	public Equity updateEquity(Equity e,String SecuritySymbol);
	public Equity deleteEquity(String SecuritySymbol);
	public Equity addEquity(Equity e,Security s);
	public List<enrichedEquity> getEquity(int customerId);
}
