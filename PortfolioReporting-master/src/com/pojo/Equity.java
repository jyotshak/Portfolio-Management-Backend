package com.pojo;

public class Equity extends Security{
private float faceValue;

public float getFaceValue() {
	return faceValue;
}

public void setFaceValue(float faceValue) {
	this.faceValue = faceValue;
}

public Equity() {
	super();
	// TODO Auto-generated constructor stub
}



public Equity(String securitySymbol, String securityType,float faceValue) {
	//super();
	super(securitySymbol, securityType);
	this.faceValue = faceValue;
}




@Override
public String toString() {
	return "Equity [faceValue=" + faceValue + "]";
}
}
