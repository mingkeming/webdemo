package com.renjack.webdemo.service.impl;

import com.renjack.webdemo.dao.TestDao;
import com.renjack.webdemo.entity.Test;
import com.renjack.webdemo.entity.TestDTO;
import com.renjack.webdemo.service.TestService;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Qukun on 2018/5/7.
 */
@Service("testService")
public class TestServiceImpl implements TestService {

	private final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Autowired
	private TestDao testDao;

	@Override
	public void createTest(TestDTO testDTO) {
		Test test = this.dto2Entity(testDTO);
		testDao.insertTest(test);
	}

	@Override
	public List<Test> batchInsertT(List<TestDTO> testDTOs) {
		List<Test> testList = Lists.newArrayList();
		for (TestDTO testDTO : testDTOs){
			Test test = this.dto2Entity(testDTO);
			testList.add(test);
		}
		testDao.batchInsertT(testList);
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
		Test test = testDao.getTest(id);

		return this.entity2DTO(test);
	}

	@Override
	public List<TestDTO> findByCondition(String name, Integer status) {
		List<Test> testList = testDao.findByCondition(name,status);
		List<TestDTO> testDTOlist = Lists.newArrayList();

		return testDTOlist;
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
		testDTO.setId(test.getId());
		testDTO.setName(test.getName());
		testDTO.setStatus(test.getStatus());
		return testDTO;
	}
}
