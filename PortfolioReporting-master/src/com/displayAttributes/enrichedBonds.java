package com.displayAttributes;

import java.sql.Date;

public class enrichedBonds {
	private String security_symbol;
	private float faceValue;
	private float couponRate;
	private float frequency;
	private Date maturity;
	private Date trade_date;
	private int quantity;
	public String getSecurity_symbol() {
		return security_symbol;
	}
	public void setSecurity_symbol(String security_symbol) {
		this.security_symbol = security_symbol;
	}
	public float getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(float faceValue) {
		this.faceValue = faceValue;
	}
	public float getCouponRate() {
		return couponRate;
	}
	public void setCouponRate(float couponRate) {
		this.couponRate = couponRate;
	}
	public float getFrequency() {
		return frequency;
	}
	public void setFrequency(float frequency) {
		this.frequency = frequency;
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
