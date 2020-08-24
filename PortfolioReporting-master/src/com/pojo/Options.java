package com.pojo;

import java.util.Date;

public class Options extends Security{
	public Options(String securitySymbol, String securityType, float strikePrice, Date expirationDate, float premium,
			int lotSize) {
		super(securitySymbol, securityType);
		this.strikePrice = strikePrice;
		this.expirationDate = expirationDate;
		this.premium = premium;
		this.lotSize = lotSize;
	}
	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Options [strikePrice=" + strikePrice + ", expirationDate=" + expirationDate + ", premium=" + premium
				+ ", lotSize=" + lotSize + "]";
	}
	
	private float strikePrice;
	private Date expirationDate;
	private float premium;
	private int lotSize;
	
	public float getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(float strikePrice) {
		this.strikePrice = strikePrice;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public float getPremium() {
		return premium;
	}
	public void setPremium(float premium) {
		this.premium = premium;
	}
	public int getLotSize() {
		return lotSize;
	}
	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}
	

}
