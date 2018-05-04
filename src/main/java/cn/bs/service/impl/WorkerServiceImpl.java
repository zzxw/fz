package cn.bs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bs.dao.WorkerDao;
import cn.bs.entity.Worker;
import cn.bs.service.NameException;
import cn.bs.service.WorkerService;
import cn.bs.tools.Tools;
@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	
	@Resource
	private WorkerDao workerDao;
	public Worker findByName(String name) {
		if(Tools.isEmpty(name)){
			throw new NameException("用户名不能为空");
		}
		Worker worker = workerDao.findByName(name);
		if(worker!=null){
			throw new NameException("该用户名已存在，请重新输入");
		}
		return null;
	}

	public Worker login(String name, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	public Worker regist(Worker worker) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateInfo(Worker worker) {
		// TODO Auto-generated method stub
		return false;
	}

}
