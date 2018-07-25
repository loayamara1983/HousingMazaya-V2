package org.bh.housing.mazaya.web;

import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bh.housing.mazaya.domain.Status;
import org.bh.housing.mazaya.repository.lookup.CategoryRepository;
import org.bh.housing.mazaya.repository.lookup.StatusRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author Loay
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
public class MazayaLookupsRepoTests {

	@Autowired
	private StatusRepository statusRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Before
	public void setup() {
		Status status = new Status();

		status.setName("pending");
		status.setDisplayName("Pending");
		status.setDescription("Pending status");
		status.setActive(true);

		statusRepo.saveAndFlush(status);
		
		status = new Status();

		status.setName("terminated");
		status.setDisplayName("Terminated");
		status.setDescription("Terminated status");
		status.setActive(false);

		statusRepo.saveAndFlush(status);
	}

	@After
	public void destroy() {

	}

	@Test
	public void testFindAllStatuses() {
		List<Status> statuses = statusRepo.findAll();
		assertFalse("Statuses may not be empty nor null", CollectionUtils.isEmpty(statuses));
	}

	@Test
	public void testFindAllActiveStatuses() {
		List<Status> statuses = statusRepo.findAllActive();
		assertFalse("Statuses may not be empty nor null", CollectionUtils.isEmpty(statuses));
	}

	@Test
	public void testCountStatuses() {
		long count = statusRepo.count();
		assertFalse("Statuses count must be greater than 0", count == 0);
	}
	
	@Test
	public void testCountActiveStatuses() {
		Map<String, Object> params=new HashMap<>();
		params.put("active", false);
		
		long count = statusRepo.count(params);
		assertFalse("Statuses count must be greater than 0", count == 0);
	}
}
