package com.renjack.webdemo.entity.auth;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class RsUser {

	private Integer id;

	private String userName;

	private Integer userPassword;

	private String userEmail;

	private String saltCode;

	private Boolean isUse;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;
}
