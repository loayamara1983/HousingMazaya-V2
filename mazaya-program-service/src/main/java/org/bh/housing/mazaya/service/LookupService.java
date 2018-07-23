package org.bh.housing.mazaya.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.bh.housing.mazaya.domain.Category;
import org.bh.housing.mazaya.domain.Status;
import org.bh.housing.mazaya.repository.lookup.CategoryRepository;
import org.bh.housing.mazaya.repository.lookup.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookupService {
	
	@Autowired
	private StatusRepository statusRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@PostConstruct
	public void init() {
		Status status = new Status();
		status.setActive(true);
		status.setName("new");
		status.setDisplayName("New");
		status.setDescription("New status");
		statusRepo.saveAndFlush(status);
		
		List<Status> statuses = statusRepo.findAllActive();
		System.out.println("statuses count: " +statuses.size());
		
		Optional<Status> newStatus = statusRepo.findByName("new");
		newStatus.ifPresent(s -> {
			System.out.println(s.getDisplayName());
		});
		
		List<Category> categories = categoryRepo.findAllActive();
		System.out.println("categories count: " +categories.size());
		
	}
	
}
