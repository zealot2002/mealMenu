package org.zzy.mealmenu.moudle.home.model;

import android.nfc.Tag;

import java.util.List;


/*菜品*/
public class Dish {
    private Integer id;
    private String name;
    private Double price;
    private String cover;
    
	private List<Tag> tagList;
    
    private Category category;
    
    
    /****************************************************************************************************************/
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }


    
}