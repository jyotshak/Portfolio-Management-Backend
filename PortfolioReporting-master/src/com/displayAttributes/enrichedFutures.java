package com.displayAttributes;

import java.sql.Date;

public class enrichedFutures {
	private String security_symbol;
	private Date maturity;
	private Date trade_date;
	private int quantity;
	public String getSecurity_symbol() {
		return security_symbol;
	}
	public void setSecurity_symbol(String security_symbol) {
		this.security_symbol = security_symbol;
	}
	public Date getMaturity() {
		return maturity;
	}
	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}
	public Date getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
