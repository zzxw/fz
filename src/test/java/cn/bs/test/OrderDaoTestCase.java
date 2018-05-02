package cn.bs.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.bs.dao.OrderDao;
import cn.bs.dao.TicketDao;
import cn.bs.entity.ChangeOrder;
import cn.bs.entity.Order;
import cn.bs.entity.Ticket;



public class OrderDaoTestCase 
	extends BaseTestCase{
	OrderDao odao;
	TicketDao tdao;
	
	@Before
	public void initDao(){
		odao=ctx.getBean("orderDao",OrderDao.class);
		tdao=ctx.getBean("ticketDao", TicketDao.class);
	}
	
	@Test 
	public void addOrder(){
		Ticket t=tdao.queryByCode("k80");
		//Order order=new Order(t.getTrainCode(),t.getStartStation(),t.getStartTime(),
				//t.ArriveStation,t.ArriveTime,"zz","320721199906004000",t.getTicketPrice(),
				//t.getDate(),"待支付");
		Order order=new Order("k80","淮安","05:28","广州","15:30","zz","320721199906004000",250,"2017-5-12","待支付");
		int i=odao.addOrder(order);
		System.out.println(i);
	}
	@Test
	public void testDelete() throws ParseException{
		int id=1;
		//int i=odao.deleteOrder(id);
		//System.out.println(i);
		Date date=new Date();
		Order o=odao.queryById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date1=sdf.parse(o.getDate()+" "+o.getStartTime());
		System.out.println(date);
		System.out.println(date1);
		System.out.println(date.before(date1));
		//Order o=odao.queryById(id);
		//System.out.println(date-o.getDate());
	}
	
	@Test
	public void testUpdate(){
		String trainCode="k80";
		Ticket t=tdao.queryByCode(trainCode);
		ChangeOrder corder=new ChangeOrder(1,trainCode,t.getStartTime(),t.getArriveTime(),t.getTicketPrice(),
				t.getDate(),"改签票");
		int i=odao.updateOrder(corder);
		System.out.println(i);
	}
	@Test
	public void testQueryOrder(){
		String username="zz";
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list=odao.queryOrders(username);
		for(Map<String,Object> map: list){
			System.out.println(map);
		}
	}
}






