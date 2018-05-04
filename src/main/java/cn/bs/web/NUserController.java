package cn.bs.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bs.entity.NUser;
import cn.bs.service.NUserService;
import cn.bs.util.JsonResult;

@Controller
@RequestMapping("/user")
public class NUserController {
	@Resource
	private NUserService nService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<NUser> regist(String uName,String pwd,String phone,String address,String major){
		NUser nUser = new NUser();
		nUser.setAddress(address);
		nUser.setMajor(major);
		nUser.setPhone(phone);
		nUser.setPwd(pwd);
		nUser.setuName(uName);
		NUser user=nService.regist(nUser);
		return new JsonResult<NUser>(user);
	}
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult<NUser> changePW
	(String uName,String pwd,String phone,String address,String major){
		NUser nUser = new NUser();
		nUser.setAddress(address);
		nUser.setMajor(major);
		nUser.setPhone(phone);
		nUser.setPwd(pwd);
		nUser.setuName(uName);
		NUser user=nService.regist(nUser);
		return new JsonResult<NUser>(user);
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult<NUser> find(String name){
		NUser user=nService.findByName(name);
		return new JsonResult<NUser>(user);
	}
}
