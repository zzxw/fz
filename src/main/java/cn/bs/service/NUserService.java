package cn.bs.service;

import java.util.List;

import cn.bs.entity.NUser;

public interface NUserService {
	NUser findByName (String name);
	NUser login(String name,String pwd);
	NUser regist(NUser user);
	boolean updateInfo(NUser nUser);
	List<String> findUsersByMajor(String major);
	List<String> findUsersByType(int userType);
}
