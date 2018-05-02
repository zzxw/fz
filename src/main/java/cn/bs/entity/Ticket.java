
package cn.bs.entity;

import java.io.Serializable;

public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3804975850552698634L;
	public String TrainCode;// 车次
	public String StartStation;// 出发站
	public String StartTime;// 出发时间
	public String ArriveStation;// 到达站
	public String ArriveTime;// 到达时间
	public String UseTime;// 用时
	public int TicketNum;// 余票
	public float TicketPrice;// 票价
	public String Date;// 日期
	
	
	public Ticket() {
		super();
	}
	public Ticket(String trainCode, String startStation, String startTime,
			String arriveStation, String arriveTime, String useTime,
			int ticketNum, int ticketPrice, String date) {
		super();
		TrainCode = trainCode;
		StartStation = startStation;
		StartTime = startTime;
		ArriveStation = arriveStation;
		ArriveTime = arriveTime;
		UseTime = useTime;
		TicketNum = ticketNum;
		TicketPrice = ticketPrice;
		Date = date;
	}
	public String getTrainCode() {
		return TrainCode;
	}
	public void setTrainCode(String trainCode) {
		TrainCode = trainCode;
	}
	public String getStartStation() {
		return StartStation;
	}
	public void setStartStation(String startStation) {
		StartStation = startStation;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getArriveStation() {
		return ArriveStation;
	}
	public void setArriveStation(String arriveStation) {
		ArriveStation = arriveStation;
	}
	public String getArriveTime() {
		return ArriveTime;
	}
	public void setArriveTime(String arriveTime) {
		ArriveTime = arriveTime;
	}
	public String getUseTime() {
		return UseTime;
	}
	public void setUseTime(String useTime) {
		UseTime = useTime;
	}
	public int getTicketNum() {
		return TicketNum;
	}
	public void setTicketNum(int ticketNum) {
		TicketNum = ticketNum;
	}
	public float getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "Ticket [TrainCode=" + TrainCode + ", StartStation=" + StartStation + ", StartTime=" + StartTime
				+ ", ArriveStation=" + ArriveStation + ", ArriveTime=" + ArriveTime + ", UseTime=" + UseTime
				+ ", TicketNum=" + TicketNum + ", TicketPrice=" + TicketPrice + ", Date=" + Date + "]";
	}
	
	
}
