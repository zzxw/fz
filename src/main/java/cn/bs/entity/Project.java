package cn.bs.entity;

public class Project {
	private Integer pid;
	private Integer uid;
	private Integer checkId;
	private Integer authorizedId;
	private String majorType;
	private String pName;
	private Integer pType;
	private String unitName;
	private String contacts;
	private String cPhone;
	private Integer status;
	private String blueprint;
	
	public Project() {
		super();
	}

	
	public Project(Integer pid, Integer uid, Integer checkId, Integer authorizedId, String majorType, String pName, Integer pType,
			String unitName, String contacts, String cPhone, Integer status, String blueprint) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.checkId = checkId;
		this.authorizedId = authorizedId;
		this.majorType = majorType;
		this.pName = pName;
		this.pType = pType;
		this.unitName = unitName;
		this.contacts = contacts;
		this.cPhone = cPhone;
		this.status = status;
		this.blueprint = blueprint;
	}


	public int getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getMajorType() {
		return majorType;
	}

	public void setMajorType(String majorType) {
		this.majorType = majorType;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBlueprint() {
		return blueprint;
	}

	public void setBlueprint(String blueprint) {
		this.blueprint = blueprint;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public int getCheckId() {
		return checkId;
	}


	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}


	public int getAuthorizedId() {
		return authorizedId;
	}


	public void setAuthorizedId(Integer authorizedId) {
		this.authorizedId = authorizedId;
	}


	public int getpType() {
		return pType;
	}


	public void setpType(Integer pType) {
		this.pType = pType;
	}


	public String getcPhone() {
		return cPhone;
	}


	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
