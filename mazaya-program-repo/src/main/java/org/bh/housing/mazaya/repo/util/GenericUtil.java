package org.bh.housing.mazaya.repo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author Loay
 *
 */
public class GenericUtil {

	public static <T> void applySearchFilter(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			CriteriaQuery<T> criteriaQuery, Root<T> from) {

		if (CollectionUtils.isEmpty(params)) {
			return;
		}

		final List<Predicate> predicates = new ArrayList<Predicate>();

		for (final Map.Entry<String, Object> param : params.entrySet()) {

			final String key = param.getKey();
			final Object value = param.getValue();

			if ((key != null) && (value != null)) {

				if (value.toString().contains("%")) {
					predicates.add(criteriaBuilder.like(from.<String>get(key), value.toString()));
				} else {
					predicates.add(criteriaBuilder.equal(from.get(key), value));
				}
			}
		}

		criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
	}

	public static <T> void applyQuerySort(Sort sort, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery,
			Root<T> from) {

		if (sort == null) {
			return;
		}

		Iterator<Order> iterator = sort.iterator();
		while (iterator.hasNext()) {
			Order order = iterator.next();

			if (order.isAscending()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(from.get(order.getProperty())));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(from.get(order.getProperty())));
			}
		}
	}

	public static <T> void applyQueryPagination(Pageable pageable, TypedQuery<T> query) {
		if (pageable == null) {
			return;
		}

		query.setFirstResult(pageable.getPageNumber());
		query.setMaxResults(pageable.getPageSize());
	}
}
