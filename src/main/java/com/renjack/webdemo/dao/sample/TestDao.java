package com.renjack.webdemo.dao.sample;

import com.renjack.webdemo.entity.sample.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//本注解作用是再启动类不需要再配置扫描dao包。
public interface TestDao {

	@Select("SELECT * FROM tb_test WHERE id = #{id}")
	Test getTest(@Param("id") Long id);

	@Insert("INSERT INTO tb_test(name, status) VALUES(#{test.name}, #{test.status})")
	void insertTest(@Param("test") Test test);

	@Delete("DELETE FROM tb_test WHERE id = #{id})")
	void deleteTest(@Param("id") Long id);

	@Update("UPDATE tb_test SET name = #{test.name} AND status = #{test.status} WHERE id = #{test.id})")
	void updateTest(@Param("test") Test test);

	void batchInsert(List<Test> testList);

	List<Test> findByCondition(@Param("name") String name, @Param("status") Integer status);

	void insert(@Param("test") Test test);

}
