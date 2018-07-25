package org.bh.housing.mazaya.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * 
 * @author Loay
 *
 * @param <T>
 * @param <ID>
 */
public class MazayaProgramRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements MazayaProgramRepository<T, ID> {

	private MazayaProgramJpaTemplate<T> jpaTemplate;

	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public MazayaProgramRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);

		this.jpaTemplate = new MazayaProgramJpaTemplate<T>(entityManager, getDomainClass());
	}

	/**
	 * 
	 */
	@Override
	public List<T> findAll(Map<String, Object> params) {
		return this.jpaTemplate.findAll(params);
	}

	/**
	 * 
	 */
	@Override
	public List<T> findAll(Map<String, Object> params, Sort sort, Pageable pageable) {
		return this.jpaTemplate.findAll(params, sort, pageable);
	}

	@Override
	public long count(Map<String, Object> params) {
		return this.jpaTemplate.count(params);
	}
}
