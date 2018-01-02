package com.yym.commons.webservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yym.commons.webservice.entity.WebserviceTestEntity;
import com.yym.commons.webservice.model.WebserviceTest;
import com.yym.commons.webservice.repository.WebserviceTestRepository;

/**
 * Service : Test
 * 
 * @Author JALO
 * 
 */
@Service
public class WebserviceTestService {

	@Autowired
	private WebserviceTestRepository webserviceTestRepository;
	
	/**
	 * Query All.
	 * 
	 * @param page
	 * @param size
	 * @param orders
	 * @return list
	 */
	public List<WebserviceTest> findAll(Integer page, Integer size, List<Order> orders) {
		Page<WebserviceTestEntity> entityPage = webserviceTestRepository.findAll(new PageRequest(page, size, new Sort(orders)));
		List<WebserviceTest> modelList = new ArrayList<>();
		
		entityPage.forEach(entity -> {
			modelList.add(convert(entity));
		});
		
		return modelList;
	}
	
	/**
	 * Query by id.
	 * 
	 * @param id
	 * @return model
	 */
	public WebserviceTest findOne(Long id) {
		return convert(webserviceTestRepository.findOne(id));
	}
	
	/**
	 * Save if model has not id.
	 * Update if model has id.
	 * 
	 * @param model
	 * @return model
	 */
	@Transactional
	public WebserviceTest saveOrUpdate(WebserviceTest model) {
		if (model == null) {
			return null;
		}
		
		WebserviceTestEntity entity = convert(model);
		
		WebserviceTest resultModel = null;
		try {
			resultModel = convert(webserviceTestRepository.saveAndFlush(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultModel;
	}
	
	/**
	 * Delete by id.
	 * 
	 * @param id
	 * @return id
	 */
	@Transactional
	public Long delete(Long id) {
		try {
			webserviceTestRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * Convert WebserviceTestEntity to WebserviceTest.
	 * 
	 * @param entity
	 * @return model
	 */
	private WebserviceTest convert(WebserviceTestEntity entity) {
		if (entity == null) {
			return null;
		}
		
		WebserviceTest model = new WebserviceTest();
		
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setEmail(entity.getEmail());
		
		return model;
	}
	
	/**
	 * Convert WebserviceTest to WebserviceTestEntity.
	 * 
	 * @param model
	 * @return
	 */
	private WebserviceTestEntity convert(WebserviceTest model) {
		if (model == null) {
			return null;
		}
		
		WebserviceTestEntity entity = new WebserviceTestEntity();
		
		if (model.getId() != null) {
			entity.setId(model.getId());
		}
		if (model.getName() != null) {
			entity.setName(model.getName());
		}
		if (model.getEmail() != null) {
			entity.setEmail(model.getEmail());
		}
		
		return entity;
	}
}
