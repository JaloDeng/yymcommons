package com.yym.commons.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yym.commons.webservice.entity.WebserviceTestEntity;

/**
 * Repository : Test
 * 
 * @Author JALO
 * 
 */
public interface WebserviceTestRepository extends JpaRepository<WebserviceTestEntity, Long>, JpaSpecificationExecutor<WebserviceTestEntity> {

}
