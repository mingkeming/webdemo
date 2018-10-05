package com.renjack.webdemo.service;



import com.renjack.webdemo.entity.Test;
import com.renjack.webdemo.entity.TestDTO;

import java.util.List;

/**
 * Created by Qukun on 2018/5/7.
 */
public interface TestService {

	public void createTest(TestDTO testDTO);

    public List<Test> batchInsertT(List<TestDTO> testDTOs);

	public void deleteTest(Long id);

	public void updateTest(TestDTO testDTO);

	public TestDTO findTest(Long id);

	public List<TestDTO> findByCondition(String name, Integer status);


}