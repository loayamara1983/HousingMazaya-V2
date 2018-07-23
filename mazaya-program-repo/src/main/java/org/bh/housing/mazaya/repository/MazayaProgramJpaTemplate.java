package org.bh.housing.mazaya.repository;

import static org.bh.housing.mazaya.repository.QueryFilterSupport.applyQueryPagination;
import static org.bh.housing.mazaya.repository.QueryFilterSupport.applyQuerySort;
import static org.bh.housing.mazaya.repository.QueryFilterSupport.applySearchFilter;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

/**
 * 
 * @author Loay
 *
 * @param <T>
 */
public class MazayaProgramJpaTemplate<T> {

	private final EntityManager entityManager;
	private final Class<T> entityClass;

	/**
	 * 
	 * @param entityInformation2
	 * @param entityManager
	 * @param entityClass
	 */
	public MazayaProgramJpaTemplate(EntityManager entityManager,
			Class<T> entityClass) {
		
		super();
		this.entityManager = entityManager;
		this.entityClass = entityClass;
	}
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<T> findAll(Map<String, Object> params){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);

		Root<T> from = criteriaQuery.from(this.entityClass);

		applySearchFilter(params, criteriaBuilder, criteriaQuery, from);

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	/**
	 * 
	 * @param params
	 * @param sort
	 * @param pageable
	 * @return
	 */
	public List<T> findAll(Map<String, Object> params, Sort sort, Pageable pageable){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);

		Root<T> from = criteriaQuery.from(this.entityClass);

		applySearchFilter(params, criteriaBuilder, criteriaQuery, from);

		applyQuerySort(sort, criteriaBuilder, criteriaQuery, from);

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);

		applyQueryPagination(pageable, query);

		return query.getResultList();
	}
}
