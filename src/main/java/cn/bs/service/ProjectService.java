package cn.bs.service;


import java.util.List;

import cn.bs.entity.Project;

public interface ProjectService {
	Project add(Project project);
	boolean update(Project project);
	boolean delete(int id);
	Project search(int id);
	List<Project> findProjects();
	List<Project> findProjectsByStatus(int status);
}
