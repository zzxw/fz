package cn.bs.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bs.entity.ChangeOrder;
import cn.bs.entity.Order;
import cn.bs.entity.Ticket;
import cn.bs.service.OrderService;
import cn.bs.util.JsonResult;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	@Resource
	private OrderService oservice;
	
	@RequestMapping("/add")
	@ResponseBody
	public JsonResult<Boolean> add(Order order){
		boolean b=oservice.add(order);
		return new JsonResult<Boolean>(b);
	}
	@RequestMapping("/delete")
	@ResponseBody

	public JsonResult<Boolean> delete(String id) throws ParseException{
		boolean b=oservice.delete(id);
		return new JsonResult<Boolean>(b);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult<Boolean> update(ChangeOrder corder){
		boolean b=oservice.update(corder);
		return new JsonResult<Boolean>(b);
	}
	@RequestMapping("/query")
	@ResponseBody
	public JsonResult<ArrayList<Map<String, Object>>> query(String username){
		ArrayList<Map<String, Object>> alist=oservice.query(username);
		return new JsonResult<ArrayList<Map<String, Object>>>(alist);
	}
}
