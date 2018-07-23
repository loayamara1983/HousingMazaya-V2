package org.bh.housing.mazaya.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BasicLookup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8231274158902172692L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String displayName;
	
	@Column
	private String description;
	
	@Column
	private Boolean active;
}
