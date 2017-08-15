package org.zzy.mealmenu.moudle.home.model;

import org.json.JSONException;
import org.json.JSONObject;


/*分类*/
public class Category {
	private Integer id;
	private String name;

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

	public String toString() {
		String info = "";
		JSONObject jsonInfo = new JSONObject();
		try {
			jsonInfo.put("id", id);
			jsonInfo.put("name", name);
			info = jsonInfo.toString();
			return info;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

}