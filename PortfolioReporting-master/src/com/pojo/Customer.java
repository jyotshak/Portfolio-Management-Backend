package com.pojo;

import java.util.Date;

public class Customer {
	private int Customer_id;
	private String fullname;
	private Date date_of_birth;
	private String place_of_birth;
	private String gender;
	private String nationality;
	private String address;
	public Customer(int customer_id, String fullname, Date date_of_birth, String place_of_birth, String gender,
			String nationality, String address, String mobileNo, String adhar_no, String pan_no, String account_no) {
		super();
		Customer_id = customer_id;
		this.fullname = fullname;
		this.date_of_birth = date_of_birth;
		this.place_of_birth = place_of_birth;
		this.gender = gender;
		this.nationality = nationality;
		this.address = address;
		this.mobileNo = mobileNo;
		this.adhar_no = adhar_no;
		this.pan_no = pan_no;
		this.account_no = account_no;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [Customer_id=" + Customer_id + ", fullname=" + fullname + ", date_of_birth=" + date_of_birth
				+ ", place_of_birth=" + place_of_birth + ", gender=" + gender + ", nationality=" + nationality
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", adhar_no=" + adhar_no + ", pan_no=" + pan_no
				+ ", account_no=" + account_no + "]";
	}
	private String mobileNo;
	private String adhar_no;
	private String pan_no;
	private String account_no;
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPlace_of_birth() {
		return place_of_birth;
	}
	public void setPlace_of_birth(String place_of_birth) {
		this.place_of_birth = place_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String string) {
		this.mobileNo = string;
	}
	public String getAdhar_no() {
		return adhar_no;
	}
	public void setAdhar_no(String adhar_no) {
		this.adhar_no = adhar_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
}
