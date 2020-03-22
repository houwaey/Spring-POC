package com.local.springjdbc.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student implements Serializable {

	private long id;
	private String studentId;
	private String name;
	private Date dateCreated;
	
}
