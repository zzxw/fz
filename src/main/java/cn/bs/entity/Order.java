
package cn.bs.entity;

import java.io.Serializable;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4048722516459794085L;
	private Integer id;//订单编号
	private String trainCode;//车次
	private String startStation;// 始发站
	private String startTime;// 出发时间
	private String arriveStation;// 到达站
	private String arriveTime;// 到达时间
	private String username;//乘客姓名
	private String userIdNum;//乘客身份证号码
	private double ticketPrice;// 票价
	private String date;// 日期
	private String status;// 车票状态״̬
	public Order(String trainCode, String startStation, String startTime,
			String arriveStation, String arriveTime, String username,
			String userIdNum, double ticketPrice, String date, String status) {
		super();
		this.trainCode = trainCode;
		this.startStation = startStation;
		this.startTime = startTime;
		this.arriveStation = arriveStation;
		this.arriveTime = arriveTime;
		this.username = username;
		this.userIdNum = userIdNum;
		this.ticketPrice = ticketPrice;
		this.date = date;
		this.status = status;
	}
	public Order() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainCode() {
		return trainCode;
	}
	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArriveStation() {
		return arriveStation;
	}
	public void setArriveStation(String arriveStation) {
		this.arriveStation = arriveStation;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserIdNum() {
		return userIdNum;
	}
	public void setUserIdNum(String userIdNum) {
		this.userIdNum = userIdNum;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", trainCode=" + trainCode + ", startStation=" + startStation + ", startTime="
				+ startTime + ", arriveStation=" + arriveStation + ", arriveTime=" + arriveTime + ", username="
				+ username + ", userIdNum=" + userIdNum + ", ticketPrice=" + ticketPrice + ", date=" + date
				+ ", status=" + status + "]";
	}
	
}
