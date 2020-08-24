package com.dao;


import java.util.List;

import com.displayAttributes.enrichedBonds;
import com.pojo.Bond;
import com.pojo.Security;

public interface BondDAO {
	public Bond getBond(String SecuritySymbol);
	public Bond updateBond(Bond b,String SecuritySymbol);
	public Bond deleteBond(String SecuritySymbol);
	public Bond addBond(Bond b,Security s);
	public List<enrichedBonds> getBond(int customerId);
}
