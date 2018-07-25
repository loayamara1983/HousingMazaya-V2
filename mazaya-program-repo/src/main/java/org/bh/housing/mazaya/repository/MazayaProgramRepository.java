package org.bh.housing.mazaya.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Loay
 *
 */

@NoRepositoryBean
public interface MazayaProgramRepository<T, ID extends Serializable>
		extends JpaRepository<T, ID> {

	List<T> findAll(Map<String, Object> params);
	
	List<T> findAll(Map<String, Object> params, Sort sort, Pageable pageable);
	
	long count(Map<String, Object> params);
}
