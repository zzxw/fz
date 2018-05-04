package cn.bs.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bs.entity.Worker;
import cn.bs.service.WorkerService;
import cn.bs.util.JsonResult;

@Controller
@RequestMapping("/worker")
public class WorkerController {
	@Resource
	private WorkerService workService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult<Worker> regist(String uName,String pwd,String phone,String mail,int userType){
		Worker worker = new Worker();
		worker.setMail(mail);
		worker.setPhone(phone);
		worker.setPwd(pwd);
		worker.setuName(uName);
		worker.setUserType(userType);
		workService.regist(worker);
		return new JsonResult<Worker>(worker);
	}
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult<Worker> changePW
	(String uName,String pwd,String phone,String mail){
		Worker worker = new Worker();
		worker.setMail(mail);
		worker.setPhone(phone);
		worker.setPwd(pwd);
		worker.setuName(uName);
		workService.updateInfo(worker);
		return new JsonResult<Worker>(worker);
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult<Worker> find(String name){
		Worker worker=workService.findByName(name);
		return new JsonResult<Worker>(worker);
	}
}
