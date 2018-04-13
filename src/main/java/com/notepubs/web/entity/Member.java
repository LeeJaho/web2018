package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	/*@Column("dddd")*/
	private String id;
	private String pwd;
	private String name;
	private String photo;
	
	public Member() {
		
	}
	
	public Member(String id, String pwd, String name, String photo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.photo = photo;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", photo=" + photo + "]";
	}


}
