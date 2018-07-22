package org.bh.housing.mazaya.repo.generic;

import java.util.List;

import org.bh.housing.mazaya.domain.BasicLookup;
import org.bh.housing.mazaya.repo.generic.HMBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author Loay
 *
 * @param <T>
 */

@NoRepositoryBean
public interface LookupRepository<T extends BasicLookup> extends HMBaseRepository<T, Long> {

	@Query("SELECT t FROM #{#entityName} t WHERE t.active = 'true'")
	List<T> findAllActive();
}
