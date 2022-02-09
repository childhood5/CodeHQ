package com.codeHQ.springbootapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeHQ.springbootapplication.dto.Request;
import com.codeHQ.springbootapplication.model.TestEntity;
import com.codeHQ.springbootapplication.model.TransactionEntity;
import com.codeHQ.springbootapplication.repository.TestRepository;
import com.codeHQ.springbootapplication.repository.TransactionRepository;

/**
 * Here is a DeviceServiceImpl class
 * 
 * @author tong
 */
@Service
//@Transactional
public class TestServiceImpl implements TestService {

	private TestRepository repository;
	
	private TransactionRepository transactionRepository;
	
	@Autowired
	public TestServiceImpl(TestRepository repository, TransactionRepository transactionRepository) {
		this.repository = repository;
		this.transactionRepository = transactionRepository;
	}

//	@Transactional(rollbackFor = {Exception.class, Throwable.class}) Checker
	@Transactional
	@Override
	public void save(Request request) throws Exception {
		TestEntity entity = new TestEntity();
		entity.setDeviceId(request.getDeviceId());
		repository.save(entity);
		
		TransactionEntity transaction = new TransactionEntity();
		transaction.setTransactionId("abc");;
		transactionRepository.save(transaction);
		
//		throw new Exception("test");
		
//		throw new Error("test");
	}

	




}