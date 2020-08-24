package com.pojo;

public class Security {
private String securitySymbol;
private String securityType;
public String getSecuritySymbol() {
	return securitySymbol;
}
public void setSecuritySymbol(String securitySymbol) {
	this.securitySymbol = securitySymbol;
	
}
public Security() {
	super();
	// TODO Auto-generated constructor stub
}
public Security(String securitySymbol, String securityType) {
	super();
	this.securitySymbol = securitySymbol;
	this.securityType = securityType;
}
@Override
public String toString() {
	return "Security [securitySymbol=" + securitySymbol + ", securityType=" + securityType + "]";
}
public String getSecurityType() {
	return securityType;
}
public void setSecurityType(String securityType) {
	this.securityType = securityType;
}

}
