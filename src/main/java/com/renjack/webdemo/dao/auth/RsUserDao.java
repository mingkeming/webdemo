package com.renjack.webdemo.dao.auth;

import com.renjack.webdemo.entity.auth.RsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//本注解作用是再启动类不需要再配置扫描dao包。
public interface RsUserDao {

	@Select("select * from rs_user where user_name = #{rsUser.userName} AND user_password = #{rsUser.userPassword}")
	List<RsUser> getUser(@Param("rsUser") RsUser rsUser);

	void insUser(@Param("rsUser") RsUser rsUser);
}
