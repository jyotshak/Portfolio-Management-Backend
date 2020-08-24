package com.dao;


import java.util.Date;
import java.util.List;

import com.pojo.Price;
import com.pojo.Security;

public interface PriceDAO {
	public List<Price> getPriceList(String SecuritySymbol);
	public Price getPriceByDate(String SecuritySymbol, Date date);
	public Price updatePrice(Price p,String SecuritySymbol);
	public Price deletePrice(Price p,String SecuritySymbol);
	public Price addPrice(Price p, String SecuritySymbol);
}
