package com.spring.jdbc;

public class Student 
{ 
	private int id;
	private String name;
	private String city;
	private String MobileNumber;
	
	public Student() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String city, String mobileNumber) 
	{
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		MobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", MobileNumber=" + MobileNumber + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

}
