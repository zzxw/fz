package cn.bs.service;

import cn.bs.entity.Worker;

public interface WorkerService {
	/*uName;
	private String pwd;
	private String phone;
	private String mail;
	private int userType*/
	Worker findByName(String name);
	Worker login(String name,String pwd);
	Worker regist(Worker worker);
	boolean updateInfo(Worker worker);
}
