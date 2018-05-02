package cn.bs.entity;

public class ChangeOrder {
	private int id;
	private String trainCode;
	private String startTime;
	private String arriveTime;
	private float ticketPrice;
	private String date;
	private String status;
	public ChangeOrder(){
	}
	public ChangeOrder(int id, String trainCode, String startTime, String arriveTime, float ticketPrice, String date,
			String status) {
		super();
		this.id = id;
		this.trainCode = trainCode;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
		this.ticketPrice = ticketPrice;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainCode() {
		return trainCode;
	}
	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
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
		return "ChangeOrder [id=" + id + ", trainCode=" + trainCode + ", startTime=" + startTime + ", arriveTime="
				+ arriveTime + ", ticketPrice=" + ticketPrice + ", date=" + date + ", status=" + status + "]";
	}
	
}
