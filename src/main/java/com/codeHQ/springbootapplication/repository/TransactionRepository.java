package com.codeHQ.springbootapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.codeHQ.springbootapplication.model.TransactionEntity;

/**
 * Here is an DeviceRepository interface
 * 
 * @author tong
 */
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
	
}
