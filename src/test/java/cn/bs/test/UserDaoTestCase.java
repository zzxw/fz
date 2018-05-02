package cn.bs.test;

import org.junit.Before;
import org.junit.Test;

import cn.bs.dao.UserDao;
import cn.bs.entity.User;



public class UserDaoTestCase 
	extends BaseTestCase{
	UserDao dao;
	
	@Before
	public void initDao(){
		dao=ctx.getBean("userDao", UserDao.class);
	}
	
	@Test 
	public void testFindUserByName(){
		String name="zz";
		User user=dao.queryByName(name);
		System.out.println(user);
	}
	
	@Test
	public void testSaveUser(){
		User user = new User("zz","199566","h446360065@163.com","13275173993","z","320721199906004000");
		int i=dao.register(user);
		System.out.println(i);
	}
}






