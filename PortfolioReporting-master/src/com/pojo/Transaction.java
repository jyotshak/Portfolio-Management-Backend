package com.pojo;

import java.util.Date;

public class Transaction {
	private int customer_id;
	private String transaction_id;
	private Date trade_date;
	private Security security;
	private int quantityOfTradedSecurity;
	@Override
	public String toString() {
		return "Transaction [customer_id=" + customer_id + ", transaction_id=" + transaction_id + ", trade_date="
				+ trade_date + ", security=" + security + ", quantityOfTradedSecurity=" + quantityOfTradedSecurity
				+ "]";
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Date getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}
	public Security getSecurity() {
		return security;
	}
	public void setSecurity(Security security) {
		this.security = security;
	}
	public int getQuantityOfTradedSecurity() {
		return quantityOfTradedSecurity;
	}
	public void setQuantityOfTradedSecurity(int quantityOfTradedSecurity) {
		this.quantityOfTradedSecurity = quantityOfTradedSecurity;
	}
	public Transaction(int customer_id, String transaction_id, Date trade_date, Security security,
			int quantityOfTradedSecurity) {
		super();
		this.customer_id = customer_id;
		this.transaction_id = transaction_id;
		this.trade_date = trade_date;
		this.security = security;
		this.quantityOfTradedSecurity = quantityOfTradedSecurity;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
