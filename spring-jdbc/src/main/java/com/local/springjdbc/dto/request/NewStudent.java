package com.local.springjdbc.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class NewStudent implements Serializable {

	private String studentId;
	private String name;
	
}
