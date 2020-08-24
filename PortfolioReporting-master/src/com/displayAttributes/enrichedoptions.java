package com.displayAttributes;

import java.sql.Date;

public class enrichedoptions {
private String security_symbol;
private float strikePrice;
private Date ExpirationDate;
private float premium;
private int LotSize;
private Date trade_date;
private int Quantity;
public String getSecurity_symbol() {
	return security_symbol;
}
public void setSecurity_symbol(String security_symbol) {
	this.security_symbol = security_symbol;
}
public float getStrikePrice() {
	return strikePrice;
}
public void setStrikePrice(float strikePrice) {
	this.strikePrice = strikePrice;
}
public Date getExpirationDate() {
	return ExpirationDate;
}
public void setExpirationDate(Date expirationDate) {
	ExpirationDate = expirationDate;
}
public float getPremium() {
	return premium;
}
public void setPremium(float premium) {
	this.premium = premium;
}
public int getLotSize() {
	return LotSize;
}
public void setLotSize(int lotSize) {
	LotSize = lotSize;
}
public Date getTrade_date() {
	return trade_date;
}
public void setTrade_date(Date trade_date) {
	this.trade_date = trade_date;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
}
