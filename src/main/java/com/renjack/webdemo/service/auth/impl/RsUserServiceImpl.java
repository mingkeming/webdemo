package com.renjack.webdemo.service.auth.impl;

import com.renjack.webdemo.dao.auth.RsUserDao;
import com.renjack.webdemo.entity.auth.RsUser;
import com.renjack.webdemo.service.auth.RsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class RsUserServiceImpl implements RsUserService {

	@Resource
	private RsUserDao rsUserDao;

	@Override
	public List<RsUser> getUser(RsUser rsUser) {
		return rsUserDao.getUser(rsUser);
	}

	@Override
	public void insUser(RsUser rsUser) {
		rsUserDao.insUser(rsUser);
	}
}
