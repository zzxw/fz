package cn.bs.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bs.entity.NUser;
import cn.bs.service.NUserService;
import cn.bs.util.JsonResult;

@Controller
@RequestMapping("/nUser")
public class NUserController {
	@Resource
	private NUserService nService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<NUser> regist(String uName,String pwd,String phone,String mail,String address,String major,Integer userType){
		NUser nUser = new NUser();
		nUser.setAddress(address);
		nUser.setMail(mail);
		nUser.setUserType(userType);
		nUser.setMajor(major);
		nUser.setPhone(phone);
		nUser.setPwd(pwd);
		nUser.setuName(uName);
		NUser user=nService.regist(nUser);
		return new JsonResult<NUser>(user);
	}
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult<Boolean> changePW
	(String uName,String pwd,String phone,String mail,String address,String major,Integer userType){
		String oldName = "";
		NUser nUser = new NUser();
		nUser.setAddress(address);
		nUser.setMajor(major);
		nUser.setMail(mail);
		nUser.setPhone(phone);
		nUser.setPwd(pwd);
		nUser.setUserType(userType);
		nUser.setuName(uName);
		boolean isSuccess=nService.updateInfo(oldName,nUser);
		return new JsonResult<Boolean>(isSuccess);
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult<NUser> find(String name){
		NUser user=nService.findByName(name);
		return new JsonResult<NUser>(user);
	}
	
	@RequestMapping("/findUsersByMajor.do")
	@ResponseBody
	public JsonResult<List<String>> findUsersByMajor(String major){
		List<String> list = nService.findUsersByMajor(major);
		return new JsonResult<List<String>>(list);
	}
	
	@RequestMapping("/findUsersByType.do")
	@ResponseBody
	public JsonResult<List<String>> findUsersByType(Integer userType){
		List<String> list = nService.findUsersByType(userType);
		return new JsonResult<List<String>>(list);
	}
}
