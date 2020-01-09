package com.renjack.webdemo.service;

import com.renjack.webdemo.entity.Test;
import com.renjack.webdemo.entity.TestDTO;

import java.util.List;

public interface TestService {

	static String method1(){
		return "china";
	}

	void createTest(TestDTO testDTO);

    List<Test> batchInsert(List<TestDTO> testDTOs);

	void deleteTest(Long id);

	void updateTest(TestDTO testDTO);

	TestDTO findTest(Long id);

	List<Test> findByCondition(String name, Integer status);
}
