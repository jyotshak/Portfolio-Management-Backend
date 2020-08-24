package com.pojo;

import java.util.Date;

public class Future extends Security{
private Date maturity;

public Date getMaturity() {
	return maturity;
}

public void setMaturity(Date maturity) {
	this.maturity = maturity;
}

public Future() {
	super();
	// TODO Auto-generated constructor stub
}

public Future(String securitySymbol, String securityType,Date maturity) {
	super(securitySymbol, securityType);
	this.maturity = maturity;
}
}
