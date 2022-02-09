package com.codeHQ.springbootapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.codeHQ.springbootapplication.model.TestEntity;

/**
 * Here is an DeviceRepository interface
 * 
 * @author tong
 */
public interface TestRepository extends CrudRepository<TestEntity, Long> {
	
}
