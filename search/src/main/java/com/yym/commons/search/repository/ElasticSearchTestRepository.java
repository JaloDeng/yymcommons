package com.yym.commons.search.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yym.commons.search.entity.ElasticSearchTestEntity;

/**
 * Repository : Test ElasticSearch
 * 
 * @Author JALO
 *
 */
public interface ElasticSearchTestRepository extends ElasticsearchRepository<ElasticSearchTestEntity, String> {

	/**
	 * Find distinct data of ElasticSearchTestEntity by name or email
	 * 
	 * @param name
	 * @param email
	 * @param pageable
	 * @return Page<ElasticSearchTestEntity>
	 */
	Page<ElasticSearchTestEntity> findDistinctElasticSearchTestEntityByNameContainingOrEmailContaining(String name, String email, Pageable pageable);
}
