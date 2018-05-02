package cn.bs.service.impl;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import cn.bs.dao.UserDao;
import cn.bs.entity.User;
import cn.bs.service.NameException;
import cn.bs.service.PasswordException;
import cn.bs.service.UserExistException;
import cn.bs.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	public User login(String name, String password) throws NameException, PasswordException {
		if(name==null || name.trim().isEmpty()){
			throw new NameException("用户名不能空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("密码不能空");
		}
		//获取用户信息, 比较密码
		User user=userDao.queryByName(name);
		if(user==null){
			throw new NameException("用户不存在");
		}
		String md5 = DigestUtils.md5Hex(
				password+"世界你好");
		
		if(md5.equals(user.getPassword())){
			return user;//登录成功
		}
		throw new PasswordException("密码错误!");
	}

	public User regist(String name,
			String password, String confirm,String email,String telNumber,
			String realName,String idCard)
			throws UserExistException, NameException, PasswordException {
		String reg= "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名不能空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能空");
		}
		if(! password.matches(reg)){
			throw new PasswordException("密码要在8-16字符之间，且必须为数字和字母的组合");
		}
		if(! password.equals(confirm)){
			throw new PasswordException("两次输入密码不一致");
		}
		//检查用户是否已经注册!
		User user = userDao.queryByName(name);
		if(user!=null){
			throw new UserExistException("该用户名已经被注册");
		}
		if(realName==null || realName.trim().isEmpty()){
			throw new NameException("姓名不能为空");
		}
		//检查了所有参数, 保存数据
		String md5 = 
			DigestUtils.md5Hex(password+"世界你好");
		user = new User(name,md5,email,telNumber,realName,idCard);
		int i=userDao.register(user);
		if(i!=1){
			throw new RuntimeException("注册失败");
		}
		return user;
	}

	public User update(String name, String oldpw, String newpw,String confirmpw) throws PasswordException {
		if(oldpw==null||oldpw.trim().isEmpty()){
			throw new PasswordException("旧密码不能为空");
		}
		if(newpw==null||newpw.trim().isEmpty()){
			throw new PasswordException("新密码不能为空");
		}
		String reg= "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(!newpw.matches(reg)){
			throw new PasswordException("密码要在8-16字符之间，并且是数字和字母的组合");
		}
		if(!newpw.equals(confirmpw)){
			throw new PasswordException("两次输入的密码不一致");
		}
		String md5 = 
				DigestUtils.md5Hex(newpw+"世界你好");
		int i=userDao.changePWD(name, md5);
		if(i!=1){
			throw new NameException("修改密码失败");
		}
		User user=userDao.queryByName(name);
		return user;
	}

	public User findByName(String name) throws NameException {
		if(name==null || name.trim().isEmpty()){
			throw new NameException("用户名不能为空");
		}
		User user=userDao.queryByName(name);
		if(user==null){
			throw new NameException("用户不存在");
		}
		return user;
	}

}
