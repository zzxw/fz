package cn.bs.dao;

import org.apache.ibatis.annotations.Param;

import cn.bs.entity.User;

public interface UserDao {
	int register(User user);
	User queryByName(String name);
	int changePWD(@Param("name")String name,@Param("newpw")String newpw);
}
