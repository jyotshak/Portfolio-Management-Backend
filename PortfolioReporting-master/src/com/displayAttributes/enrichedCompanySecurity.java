package com.displayAttributes;

import java.sql.Date;

public class enrichedCompanySecurity {
private float Price;
private Date TRADE_DATE;
private String SECURITY_SYMBOL;
private String quantity;
public float getPrice() {
	return Price;
}
public void setPrice(float price) {
	Price = price;
}
public Date getTRADE_DATE() {
	return TRADE_DATE;
}
public void setTRADE_DATE(Date tRADE_DATE) {
	TRADE_DATE = tRADE_DATE;
}
public String getSECURITY_SYMBOL() {
	return SECURITY_SYMBOL;
}
public void setSECURITY_SYMBOL(String sECURITY_SYMBOL) {
	SECURITY_SYMBOL = sECURITY_SYMBOL;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}

}
