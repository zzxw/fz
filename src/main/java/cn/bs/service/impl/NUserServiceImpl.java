package cn.bs.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.bs.dao.NUserDao;
import cn.bs.entity.NUser;
import cn.bs.service.NUserService;
import cn.bs.service.NameException;
import cn.bs.service.PasswordException;
import cn.bs.tools.Tools;
@Service("nUserService")
public class NUserServiceImpl implements NUserService {
	@Resource 
	private NUserDao userDao;
	public NUser findByName(String name) {
		if(Tools.isEmpty(name)){
			throw new NameException("用户名不能为空");
		}
		NUser nUser = userDao.findByName(name);
		if(userDao !=  null){
			throw new NameException("该用户已存在，请更换用户名");
		}
		return nUser;
	}

	public NUser login(String name, String pwd) {
		if(Tools.isEmpty(name+pwd)){
			throw new NameException("用户名和密码不能为空");
		}
		NUser user = userDao.findByName(name);
		if(user == null || !pwd.equals(user.getPwd())){
			throw new NameException("用户名或密码错误，请检查后重新输入");
		}
		return user;
	}

	public NUser regist(NUser user) {
		if(Tools.isEmpty(user.getuName() + user.getPwd())){
			throw new NameException("用户名或密码不能为空");
		}
		NUser nUser = findByName(user.getuName());
		if(nUser!=null){
			throw new NameException("该用户名已存在！！！请更换用户名重新注册");
		}
		String passwordReg= "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(!user.getPwd().matches(passwordReg)){
			throw new PasswordException("密码要在8-16字符之间，且必须为数字和字母的组合");
		}
		//String emailReg = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		String phoneReg = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
		if(!user.getPhone().matches(phoneReg)){
			throw new NameException("手机号格式不正确，请仔细检查!!!");
		}
		int i = userDao.regist(user);
		if(i!=1){
			throw new NameException("注册失败，请重新尝试");
		}
		return user;
	}

	public boolean updateInfo(NUser user) {
		if(Tools.isEmpty(user.getuName() + user.getPwd())){
			throw new NameException("用户名或密码不能为空");
		}
		String passwordReg= "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(!user.getPwd().matches(passwordReg)){
			throw new PasswordException("密码要在8-16字符之间，且必须为数字和字母的组合");
		}
		String phoneReg = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
		if(!user.getPhone().matches(phoneReg)){
			throw new NameException("手机号格式不正确，请仔细检查!!!");
		}
		int i = userDao.updateInfo(user);
		if(i!=1){
			throw new NameException("修改信息失败，请重新尝试");
		}
		return true;
	}

}
