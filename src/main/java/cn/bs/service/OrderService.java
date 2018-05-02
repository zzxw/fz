package cn.bs.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import cn.bs.entity.ChangeOrder;
import cn.bs.entity.Order;
import cn.bs.entity.Ticket;

public interface OrderService {
	boolean add(Order order);
	boolean delete(String id) throws ParseException;
	boolean update(ChangeOrder corder);
	ArrayList<Map<String,Object>> query(String username);
}
