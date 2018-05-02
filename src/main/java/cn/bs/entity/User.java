
package cn.bs.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String username;
	private String password;
	private String email;
	private String telNumber;
	private String realname;
	private String idCard;//身份证
	public User(String username, String password, String email, String telNumber,
			String realname, String idCard) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.telNumber = telNumber;
		this.realname = realname;
		this.idCard = idCard;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	@Override
	public String toString() {
		return "User ["  + " username=" + username + ", password=" + password + ", email=" + email
				+ ", telNumber=" + telNumber + ", realname=" + realname + ", idCard=" + idCard + "]";
	}
	
}
