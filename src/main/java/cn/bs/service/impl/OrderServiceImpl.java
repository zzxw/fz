package cn.bs.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bs.dao.OrderDao;
import cn.bs.dao.TicketDao;
import cn.bs.dao.UserDao;
import cn.bs.entity.ChangeOrder;
import cn.bs.entity.Order;
import cn.bs.entity.Ticket;
import cn.bs.entity.User;
import cn.bs.service.NameException;
import cn.bs.service.OrderService;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao odao;
	@Resource
	private TicketDao tdao;
	@Resource
	private UserDao udao;
	
	public boolean add(Order order) {
		if(order==null){
			throw new NameException("订单为空");
		}
		int i=odao.addOrder(order);
		Ticket t=tdao.queryByCode(order.getTrainCode());
		if(t.getTicketNum()<=0){
			throw new NameException("车票已经没啦");
		}
		if(i!=1){
			throw new NameException("添加订单失败");
		}
//		t.setTicketNum(t.getTicketNum()-1);
		return i==1;
	}
	public boolean delete(String ids) throws ParseException {
		int id=Integer.parseInt(ids);
		if(String.valueOf(id)==null||String.valueOf(id).trim().isEmpty()){
			throw new NameException("id不能为空");
		}
		if(id<=0){
			throw new NameException("id只能为正整数");
		}
		Order o=odao.queryById(id);
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String h=o.getStartTime().substring(11, 13);
		Integer newH;
		if("00".equals(h)){
			newH=23;
		}else{
			newH=Integer.parseInt(h)-1;
		}
		String h1=newH.toString();
		//Date date1=sdf.parse(o.getDate()+" "+o.getStartTime());
		Date date1=sdf.parse(o.getDate()+" "+h1);
		if(date.after(date1)){
			throw new NameException("该车票已失效，退票失败");
		}
		//String trainCode=o.getTrainCode();
		int i=odao.deleteOrder(id);
		if(i!=1){
			throw new NameException("退票失败");
		}
//		Ticket t=tdao.queryByCode(trainCode);
//		t.setTicketNum(t.getTicketNum()+1);
		return i==1;
	}
	public boolean update(ChangeOrder corder) {
		if(corder==null){
			throw new NameException("改签订单信息不能为空");
		}
		int i=0;
		Order o=odao.queryById(corder.getId());
		//Ticket t=tdao.queryByCode(o.getTrainCode());
		Ticket newt=tdao.queryByCode(corder.getTrainCode());
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date date1=sdf.parse(o.getDate()+" "+o.getStartTime());
			i=odao.updateOrder(corder);
			if(date.after(date1)){
				throw new NameException("该车票已失效，退票失败");
			}
			if(newt.getTicketNum()<=0){
				throw new NameException("你选择的车票已经空了，请重新选择车次");
			}
			if(i!=1){
				throw new NameException("改签失败");
			}
//			newt.setTicketNum(newt.getTicketNum()-1);
//			t.setTicketNum(t.getTicketNum()+1);
			}catch (ParseException e) {
				e.printStackTrace();
			}
		return i==1;
	}
	public ArrayList<Map<String, Object>> query(String username) {
		ArrayList<Map<String, Object>> alist=
			new ArrayList<Map<String, Object>>();
		if(username==null || username.trim().isEmpty()){
			throw new NameException("用户名不能为空");
		}
		User user=udao.queryByName(username);
		if(user==null){
			throw new NameException("用户不存在");
		}
		alist=odao.queryOrders(username);
		if(alist==null){
			throw new NameException("用户没有订单记录！");
		}
		return alist;
	}

	

}
