package com.pojo;

import java.util.Date;

public class Price extends Security{
private Date tradeDate;
private float price;
public Date getTradeDate() {
	return tradeDate;
}
public void setTradeDate(Date tradeDate) {
	this.tradeDate = tradeDate;
}
public Price() {
	super();
	// TODO Auto-generated constructor stub
}
public Price(String securitySymbol, String securityType) {
	super(securitySymbol, securityType);
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Price [tradeDate=" + tradeDate + ", price=" + price + "]";
}
public Price(String securitySymbol, String securityType, Date tradeDate, float price) {
	super(securitySymbol, securityType);
	this.tradeDate = tradeDate;
	this.price = price;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}
