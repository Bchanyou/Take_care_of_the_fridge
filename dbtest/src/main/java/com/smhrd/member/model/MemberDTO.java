package com.smhrd.member.model;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String pn;
	private String email;
	private String re;
	
	
	public MemberDTO(String id, String pw, String name, String pn, String email, String re) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.pn = pn;
		this.email = email;
		this.re = re;
	}
	
	//gettersetter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPn() {
		return pn;
	}
	public void setPn(String pn) {
		this.pn = pn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRe() {
		return re;
	}
	public void setRe(String re) {
		this.re = re;
	}
	
}
