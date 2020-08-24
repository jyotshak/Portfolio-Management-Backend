package com.displayAttributes;

import java.sql.Date;

public class enrichedEquity {
private Date trade_date;
private int quantityOfTradedSecurity;
private float price;
private String securitySymbol;

public Date getTrade_date() {
	return trade_date;
}
public void setTrade_date(Date trade_date) {
	this.trade_date = trade_date;
}
public int getQuantityOfTradedSecurity() {
	return quantityOfTradedSecurity;
}
public void setQuantityOfTradedSecurity(int quantityOfTradedSecurity) {
	this.quantityOfTradedSecurity = quantityOfTradedSecurity;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getSecuritySymbol() {
	return securitySymbol;
}
public void setSecuritySymbol(String securitySymbol) {
	this.securitySymbol = securitySymbol;
}

}
