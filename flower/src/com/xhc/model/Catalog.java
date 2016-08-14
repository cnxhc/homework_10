package com.xhc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String catalogName;
	private Set goodses;

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** minimal constructor */
	public Catalog(String catalogName) {
		this.catalogName = catalogName;
	}

	/** full constructor */
	public Catalog(String catalogName, Set goodses) {
		this.catalogName = catalogName;
		this.goodses = goodses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

}