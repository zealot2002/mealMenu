package org.zzy.mealmenu.moudle.home.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*订单*/
public class Ent {
	public static enum Status {待处理,处理中,待付款,已付款};
	
	private Integer id;
	private Double price;

	private String createTime;//待处理
	private String startTime;//处理中
	private String endTime;//待付款
	private String chargedTime;//已付款
	
    private Desk desk = new Desk();

	private List<Dish> dishList = new ArrayList<>();

	private String status;
	
	/****************************************************************************************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getChargedTime() {
		return chargedTime;
	}

	public void setChargedTime(String chargedTime) {
		this.chargedTime = chargedTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	

	public List<Dish> getDishList() {
		return dishList;
	}

	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}



}