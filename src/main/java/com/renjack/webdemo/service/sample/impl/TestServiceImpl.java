package com.renjack.webdemo.service.sample.impl;

import com.renjack.webdemo.dao.sample.TestDao;
import com.renjack.webdemo.entity.sample.Test;
import com.renjack.webdemo.entity.sample.TestDTO;
import com.renjack.webdemo.service.sample.TestService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;

	@Override
	public void createTest(TestDTO testDTO) {
		Test test = this.dto2Entity(testDTO);
		testDao.insertTest(test);
	}

	@Override
	public List<Test> batchInsert(List<TestDTO> testDTOs) {
		List<Test> testList = Lists.newArrayList();
		for (TestDTO testDTO : testDTOs){
			Test test = this.dto2Entity(testDTO);
			testList.add(test);
		}
		testDao.batchInsert(testList);
		return testList;
	}

	@Override
	public void deleteTest(Long id) {
		testDao.deleteTest(id);
	}

	@Override
	public void updateTest(TestDTO testDTO) {
		Test test = this.dto2Entity(testDTO);
		testDao.updateTest(test);
	}

	@Override
	public TestDTO findTest(Long id) {
		System.out.println("this is 1--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Test test = testDao.getTest(id);
		Test test1 = new Test();
		test1.setName("china");
		testDao.insert(test1);
		System.out.println(test1.toString()+"this is 1--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		return this.entity2DTO(test);
	}

	@Override
	public TestDTO findTestById(Long id) {
		System.out.println("this is 1--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Test test = testDao.getTest(id);
		System.out.println("this is 1--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		return this.entity2DTO(test);
	}

	@Override
	public List<Test> findByCondition(String name, Integer status) {
		List<Test> testList = testDao.findByCondition(name,status);
		return testList;
	}

	private Test dto2Entity(TestDTO testDTO){
		Test test = new Test();
		test.setId(testDTO.getId());
		test.setName(testDTO.getName());
		test.setStatus(testDTO.getStatus());
		return test;
	}

	private TestDTO entity2DTO(Test test){
		TestDTO testDTO = new TestDTO();
		BeanUtils.copyProperties(test,testDTO);
		return testDTO;
	}
}
