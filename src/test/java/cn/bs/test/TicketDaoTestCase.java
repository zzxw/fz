package cn.bs.test;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.bs.dao.TicketDao;
import cn.bs.entity.Ticket;



public class TicketDaoTestCase 
	extends BaseTestCase{
	TicketDao tdao;
	
	@Before
	public void initDao(){
		tdao=ctx.getBean("ticketDao", TicketDao.class);
	}
	
	@Test 
	public void testFindUserByName(){
		String trainCode="k80";
		Ticket ticket=tdao.queryByCode(trainCode);
		System.out.println(ticket);
	}
	
	@Test
	public void testAddTicket(){
		String trainCode="k81";
		int i=tdao.refundTicket(trainCode);
		System.out.println(i);
	}
	
	@Test
	public void testDeleteTicket(){
		String trainCode="k81";
		int i=tdao.sellTicket(trainCode);
		System.out.println(i);
	}
	@Test
	public void testFind(){
		String startStation="武昌";
		String arriveStation="广州";
		String date="2017-10-10";
		ArrayList<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=tdao.queryTicket(startStation, arriveStation, date);
		for(Map<String,Object> map:data){
			System.out.println(map);
		}
	}
}






