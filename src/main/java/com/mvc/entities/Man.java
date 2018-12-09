package com.mvc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="t_man")
public class Man {
	@Id  
//	@GeneratedValue(strategy = GenerationType.TABLE)  
	private Long id;
	private String name;
	private String sex;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}