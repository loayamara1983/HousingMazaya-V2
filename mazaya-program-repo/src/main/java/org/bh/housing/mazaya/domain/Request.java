package org.bh.housing.mazaya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "request")
public class Request {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String name;
}
