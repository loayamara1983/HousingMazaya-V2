package org.bh.housing.mazaya.repository.lookup;

import java.util.List;
import java.util.Optional;

import org.bh.housing.mazaya.domain.BasicLookup;
import org.bh.housing.mazaya.repository.MazayaProgramRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author Loay
 *
 * @param <T>
 */

@NoRepositoryBean
public interface LookupRepository<T extends BasicLookup> extends MazayaProgramRepository<T, Long> {

	@Query("SELECT t FROM #{#entityName} t WHERE t.name = ?1")
	Optional<T> findByName(String name);
	
	@Query("SELECT t FROM #{#entityName} t WHERE t.active = 'true'")
	List<T> findAllActive();
}
