package cn.bs.entity;

public class Worker {
	private int uid;
	private String uName;
	private String pwd;
	private String phone;
	private String mail;
	private int userType;
	public Worker() {
		super();
	}
	public Worker(int uid, String uName, String pwd, String phone, String mail, int userType) {
		super();
		this.uid = uid;
		this.uName = uName;
		this.pwd = pwd;
		this.phone = phone;
		this.mail = mail;
		this.userType = userType;
	}
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
