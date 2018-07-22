package org.bh.housing.mazaya.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.bh.housing.mazaya.domain.Category;
import org.bh.housing.mazaya.domain.Status;
import org.bh.housing.mazaya.repo.lookup.CategoryRepository;
import org.bh.housing.mazaya.repo.lookup.StatusRepository;
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
		List<Status> statuses = statusRepo.findAllActive();
		System.out.println("statuses count: " +statuses.size());
		
		List<Category> categories = categoryRepo.findAllActive();
		System.out.println("categories count: " +categories.size());
		
	}
	
}
