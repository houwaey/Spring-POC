package com.local.springjdbc.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@ApiModel
public class Student implements Serializable {

	@ApiModelProperty(value = "Record ID", example = "1001")
	private long id;
	
	@ApiModelProperty(value = "Unique ID assigned to Student", example = "A-001")
	private String studentId;
	
	@ApiModelProperty(value = "Full name of the Student", example = "Juan Dela Cruz")
	private String name;
	
	@ApiModelProperty(value = "Record's timestamp", example = "2020-03-22T14:04:52.923Z")
	private Date dateCreated;
	
}
