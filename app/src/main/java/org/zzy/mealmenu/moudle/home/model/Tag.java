package org.zzy.mealmenu.moudle.home.model;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/*标签*/
public class Tag {
	private Integer id;
	private String name;

	/****************************************************************************************************************/
	public Tag() {
		super();
	}

	public Tag(Integer id) {
		super();
		this.id = id;
	}
	
	public Tag(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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


}