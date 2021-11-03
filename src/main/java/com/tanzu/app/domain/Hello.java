package com.tanzu.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hello {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Choice a;

	@ManyToOne
	private Choice b;

	public Choice getA() {
		return a;
	}

	public Choice getB() {
		return b;
	}
}
