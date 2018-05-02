package cn.bs.service.impl;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bs.dao.TicketDao;
import cn.bs.entity.Ticket;
import cn.bs.service.NameException;
import cn.bs.service.TicketService;
@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	@Resource
	private TicketDao tdao;
	public boolean sellTickets(String trainCode) {
		if(trainCode==null || trainCode.trim().isEmpty()){
			throw new NameException("车次不能为空");
		}
		Ticket ticket=tdao.queryByCode(trainCode);
		if(ticket.getTicketNum()<=0){
			throw new NameException("车票余量为0");
		}
		int i=tdao.sellTicket(trainCode);
		if(i!=1){
			throw new NameException("售票失败");
		}
		return i==1; 
		
	}

	public boolean refundTickets(String trainCode) {
		if(trainCode==null || trainCode.trim().isEmpty()){
			throw new NameException("车次不能为空");
		}
		int i=tdao.refundTicket(trainCode);
		if(i!=1){
			throw new NameException("退票失败");
		}
		return i==1;
	}

	public Ticket findByCode(String trainCode) {
		if(trainCode==null || trainCode.trim().isEmpty()){
			throw new NameException("车次不能为空");
		}
		Ticket ticket;
		ticket=tdao.queryByCode(trainCode);
		if(ticket==null){
			throw new NameException("车次不存在");
		}
		return ticket;
	}

	public ArrayList<Map<String, Object>> findTicket(String startStation, String arriveStation, String date) {
		ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		if(startStation==null || startStation.trim().isEmpty()){
			throw new NameException("始发站不能为空");
		}
		if(arriveStation==null || arriveStation.trim().isEmpty()){
			throw new NameException("到达站不能为空");
		}
		if(date==null || date.trim().isEmpty()){
			throw new NameException("日期不能为空");
		}
		list=tdao.queryTicket(startStation, arriveStation, date);
		if(null==list || list.size()==0){
			throw new NameException("您选的车次不存在！");
		}
		return list;
	}

}
