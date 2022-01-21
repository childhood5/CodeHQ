package com.codeHQ.springbootapplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "many_to_many")
public class ManyToManyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@ManyToMany
	@JoinColumn(name = "device_id", nullable = false)
	private List<DeviceEntity> manyEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DeviceEntity> getManyEntity() {
		return manyEntity;
	}

	public void setManyEntity(List<DeviceEntity> manyEntity) {
		this.manyEntity = manyEntity;
	}

	
}