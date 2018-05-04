package cn.bs.dao;

import cn.bs.entity.NUser;

public interface NUserDao {
	int regist(NUser nUser);
	NUser findByName(String name);//findByName和login方法使用
	int updateInfo(NUser user);
}
