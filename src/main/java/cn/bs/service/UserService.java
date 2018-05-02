package cn.bs.service;

import cn.bs.entity.User;

public interface UserService {
		User findByName(String name) throws NameException;
		User login(String name, String password)
			throws NameException, PasswordException;
		User update(String name,String oldpw,String newpw,String confirmpw)throws PasswordException;
		User regist(String name,
				String password, String confirm,String email,String telNumber,
				String realName,String idCard)
					throws UserExistException, NameException, PasswordException;
}
