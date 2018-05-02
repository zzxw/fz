package cn.bs.dao;

import java.util.ArrayList;
import java.util.Map;

import cn.bs.entity.ChangeOrder;
import cn.bs.entity.Order;

public interface OrderDao {
	int addOrder(Order order);
	int deleteOrder(int id);
	int updateOrder(ChangeOrder corder);
	ArrayList<Map<String,Object>> queryOrders(String username);
	Order queryById(int id);
}
