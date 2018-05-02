package cn.bs.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.bs.entity.Ticket;

public interface TicketDao {
	int sellTicket(String trainCode);
	int refundTicket(String trainCode);
	Ticket queryByCode(String trainCode);
	ArrayList<Map<String,Object>>queryTicket(
			@Param("startStation")String startStation,
			@Param("arriveStation")String arriveStation,
			@Param("date")String date);
}
