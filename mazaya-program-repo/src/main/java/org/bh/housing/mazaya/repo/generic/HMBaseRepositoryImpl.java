package org.bh.housing.mazaya.repo.generic;

import static org.bh.housing.mazaya.repo.util.GenericUtil.applyQueryPagination;
import static org.bh.housing.mazaya.repo.util.GenericUtil.applyQuerySort;
import static org.bh.housing.mazaya.repo.util.GenericUtil.applySearchFilter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bh.housing.mazaya.repo.generic.HMBaseRepository;
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
public class HMBaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements HMBaseRepository<T, ID> {

	private final EntityManager entityManager;

	private final JpaEntityInformation<T, ID> entityInformation;

	public HMBaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);

		this.entityManager = entityManager;
		this.entityInformation = entityInformation;
	}

	@Override
	public List<T> findAll(Map<String, Object> params) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDomainClass());

		Root<T> from = criteriaQuery.from(getDomainClass());

		applySearchFilter(params, criteriaBuilder, criteriaQuery, from);

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<T> findAll(Map<String, Object> params, Sort sort, Pageable pageable) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDomainClass());

		Root<T> from = criteriaQuery.from(getDomainClass());

		applySearchFilter(params, criteriaBuilder, criteriaQuery, from);

		applyQuerySort(sort, criteriaBuilder, criteriaQuery, from);

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);

		applyQueryPagination(pageable, query);

		return query.getResultList();
	}
}
