package com.renjack.webdemo.entity;

import java.io.Serializable;

/**
 * Created by Qukun on 2018/5/7.
 */
public class TestDTO implements Serializable{

	private Long id;

	private String name;

	private Integer status;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
