package cn.bs.web;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bs.entity.Ticket;
import cn.bs.service.TicketService;
import cn.bs.util.JsonResult;

@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController {
	
	@Resource
	private TicketService ticketService;
	
	//售票
	@RequestMapping("/sell")
	@ResponseBody

	public JsonResult<Boolean> sell(String trainCode){
		boolean b=ticketService.sellTickets(trainCode);
		return new JsonResult<Boolean>(b);
		
	}
	//退票
	@RequestMapping("/refund")
	@ResponseBody

	public JsonResult<Boolean> refund(String trainCode){
		boolean b=ticketService.refundTickets(trainCode);
		return new JsonResult<Boolean>(b);
	}
	
	@RequestMapping("/queryByCode")
	@ResponseBody
	public JsonResult<Ticket> query(String trainCode){
		Ticket ticket=ticketService.findByCode(trainCode);
		return new JsonResult<Ticket>(ticket);
	}
	@RequestMapping("/queryTicket")
	@ResponseBody
	public JsonResult<ArrayList<Map<String, Object>>> queryT(
		String startStation, String arriveStation, String date){
		ArrayList<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=
			ticketService.findTicket(startStation, arriveStation, date);
		System.out.println(startStation);
		System.out.println(arriveStation);
		return new JsonResult<ArrayList<Map<String, Object>>>(data);
	}
}
