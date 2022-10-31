package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentDetails")

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	private String Name;
	private int regnumber;
	private String Address;
	private String Email;
	private String Phone;
	private int sub1;
	private int sub2;
	private int sub3;
	private int sub4;
	private int total;
	private float percentage;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRegnumber() {
		return regnumber;
	}
	public void setRegnumber(int regnumber) {
		this.regnumber = regnumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public int getSub4() {
		return sub4;
	}
	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", regnumber=" + regnumber + ", Address=" + Address + ", Email=" + Email
				+ ", Phone=" + Phone + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + ", sub4=" + sub4
				+ ", total=" + total + ", percentage=" + percentage + "]";
	}
	
	
	

}
