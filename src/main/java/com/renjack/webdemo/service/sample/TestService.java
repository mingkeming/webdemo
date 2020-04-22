package com.renjack.webdemo.service.sample;

import com.renjack.webdemo.entity.sample.Test;
import com.renjack.webdemo.entity.sample.TestDTO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface TestService {

	static String method1(){
		return "china";
	}

	static String method(){
		return "";
	}

	void createTest(TestDTO testDTO);

    List<Test> batchInsert(List<TestDTO> testDTOs);

	void deleteTest(Long id);

	void updateTest(TestDTO testDTO);

	@Cacheable(value = "redisExpire1h", key = "'test_user_'.concat(#p0)")
	TestDTO findTest(Long id);

	TestDTO findTestById(Long id);

	List<Test> findByCondition(String name, Integer status);
}
