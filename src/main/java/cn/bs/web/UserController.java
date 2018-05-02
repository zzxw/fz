package cn.bs.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bs.entity.User;
import cn.bs.service.NameException;
import cn.bs.service.PasswordException;
import cn.bs.service.UserService;
import cn.bs.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	//返回值：{state:0,data:{id...}}
	//返回值：{state:1,message:"用户名..."}
	public JsonResult<User> login(String name,
			String password){
		User user = userService.login(name, password);
		return new JsonResult<User>(user);
	}
	/**
	 * 注册控制器
	 */
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<User> regist(
			String name,
			String password, String confirm,String email,String telNumber,
			String realName,String idCard){
		User user=userService.regist(name,password,confirm,email,telNumber,realName,idCard);
		return new JsonResult<User>(user);
	}
	@RequestMapping("/changepw.do")
	@ResponseBody
	public JsonResult<User> changePW
	(String name, String oldpw, String newpw,String confirmpw){
		User user=userService.update(name, oldpw, newpw, confirmpw);
		return new JsonResult<User>(user);
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult<User> find(String name){
		User user=userService.findByName(name);
		return new JsonResult<User>(user);
	}
}
