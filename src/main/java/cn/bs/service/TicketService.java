package cn.bs.service;

import java.util.ArrayList;
import java.util.Map;


import cn.bs.entity.Ticket;

public interface TicketService {
	boolean  sellTickets(String trainCode);
	boolean refundTickets(String trainCode);
	Ticket findByCode(String trainCode);
	ArrayList<Map<String,Object>>findTicket(
			String startStation,String arriveStation,String date);
}
