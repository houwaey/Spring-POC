package com.local.springjdbc.dto.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UpdateStudent implements Serializable {

	private long id;
	private String name;
	
}
