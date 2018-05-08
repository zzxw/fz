package cn.bs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bs.dao.ProjectDao;
import cn.bs.entity.Project;
import cn.bs.service.NameException;
import cn.bs.service.ProjectService;
import cn.bs.tools.Tools;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Resource
	private ProjectDao projectDao;
	public Project add(Project project) {
		if(Tools.isEmpty(project.getpName() + project.getUnitName() + project.getContacts() + project.getcPhone())){
			throw new NameException("必填信息不能为空，请检查后重新输入提交");
		}
		String phoneReg = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
		if(!project.getcPhone().matches(phoneReg)){
			throw new NameException("手机号格式不正确，请检查后重新输入");
		}
		boolean isSuccess = projectDao.add(project);
		if(!isSuccess) {
			throw new NameException("创建项目失败，请稍后重新尝试");
		}
		return project;
	}

	public boolean update(Project project) {
		boolean isSuccess = projectDao.update(project);
		if(!isSuccess) {
			throw new NameException("项目信息更新失败，请稍候重新尝试");
		}
		return true;
	}

	public boolean delete(int id) {
		if(id<0) {
			throw new NameException("发生了未知错误，请选择要删除的记录重启尝试");
		}
		boolean isSuccess = projectDao.delete(id);
		if(!isSuccess) {
			throw new NameException("删除项目信息失败，请稍候重新尝试");
		}
		return true;
	}

	public Project search(int id) {
		if(id<0) {
			throw new NameException("发生了未知错误，请选择要删除的记录重启尝试");
		}
		Project project = projectDao.serarch(id);
		if(project == null) {
			throw new NameException("该项目不存在");
		}
		return project;
	}

	public List<Project> findProjects() {
		List<Project> list = projectDao.findProjects();
		return list;
	}

	public List<Project> findProjectsByStatus(int status) {
		if(status < 0){
			status = 0;
		}
		List<Project> list = projectDao.findProjectsByStatus(status);
		return list;
	}
	
}
