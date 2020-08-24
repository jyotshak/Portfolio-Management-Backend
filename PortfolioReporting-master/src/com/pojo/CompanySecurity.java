package com.pojo;

public class CompanySecurity extends Security {
private int CompanyId;
private String CompanyName;
private String Sector;
@Override
public String toString() {
	return "CompanySecurity [CompanyId=" + CompanyId + ", CompanyName=" + CompanyName + ", Sector=" + Sector + "]";
}
public CompanySecurity(String securitySymbol, String securityType,int companyId, String companyName, String sector) {
	super(securitySymbol,securityType);
	CompanyId = companyId;
	CompanyName = companyName;
	Sector = sector;
}
public CompanySecurity() {
	super();
	// TODO Auto-generated constructor stub
}
public CompanySecurity(String securitySymbol, String securityType) {
	super(securitySymbol, securityType);
	// TODO Auto-generated constructor stub
}
public int getCompanyId() {
	return CompanyId;
}
public void setCompanyId(int companyId) {
	CompanyId = companyId;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}
public String getSector() {
	return Sector;
}
public void setSector(String sector) {
	Sector = sector;
}
}
