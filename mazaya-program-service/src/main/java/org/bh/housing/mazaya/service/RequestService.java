package org.bh.housing.mazaya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.bh.housing.mazaya.domain.Request;
import org.bh.housing.mazaya.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
	
	@Autowired
	private RequestRepository repo;
	
	@PostConstruct
	public void init() {
		Request entity = new Request();
		entity.setId(1L);
		entity.setName("Loay");
		
		repo.save(entity);

		Map<String, Object> params=new HashMap<>();
		params.put("name", "Loay");
		List<Request> findAll = repo.findAll(params);
		System.out.println(findAll);
		
		System.out.println("count: " +repo.count());
	}
	
}
