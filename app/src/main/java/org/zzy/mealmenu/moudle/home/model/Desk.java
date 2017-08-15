package org.zzy.mealmenu.moudle.home.model;


import org.json.JSONObject;

/*桌台*/
public class Desk {
	private Integer id;
	private String name;
	private String description;
	private String status;

	/****************************************************************************************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}