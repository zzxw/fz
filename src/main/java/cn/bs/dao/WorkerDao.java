package cn.bs.dao;

import cn.bs.entity.Worker;

public interface WorkerDao {
	int regist(Worker worker);
	Worker findByName(String name);
	int update(Worker worker);
}
