package com.renjack.webdemo.dto.sample;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

@Data
public class TestDTO implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Integer status;

	private String localName;
}
