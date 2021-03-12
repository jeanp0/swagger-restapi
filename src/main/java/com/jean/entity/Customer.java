package com.jean.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;


@Entity
public class Customer {
	@Id
	@NotNull
	private String id;
	@Column
	@NotNull
	private String name;
}
