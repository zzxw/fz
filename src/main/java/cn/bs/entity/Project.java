package cn.bs.entity;

public class Project {
	private int pid;
	private String majorType;
	private String pName;
	private String unitName;
	private String contacts;
	private int status;
	private String blueprint;
	
	public Project() {
		super();
	}

	public Project(int pid, String majorType, String pName, String unitName, String contacts, int status,
			String blueprint) {
		super();
		this.pid = pid;
		this.majorType = majorType;
		this.pName = pName;
		this.unitName = unitName;
		this.contacts = contacts;
		this.status = status;
		this.blueprint = blueprint;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
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

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBlueprint() {
		return blueprint;
	}

	public void setBlueprint(String blueprint) {
		this.blueprint = blueprint;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
