package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    @Column(name="name")
	private String name;
    @Column(name="lname")
	private String lname;
    @Column(name="mailid")
	private String mailid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public Student(long id, String name, String lname, String mailid) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.mailid = mailid;
	}
	public Student() {
	
	}
	
}
