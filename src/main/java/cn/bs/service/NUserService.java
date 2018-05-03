package cn.bs.service;

import cn.bs.entity.NUser;

public interface NUserService {
	NUser findByName (String name);
	NUser login(String name,String pwd);
	NUser regist(NUser user);
	boolean updateInfo(NUser nUser);
}
