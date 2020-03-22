package com.local.springjdbc.dto.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class NewStudent implements Serializable {

	@ApiModelProperty(value = "Unique ID assigned to Student", example = "A-001")
	private String studentId;
	
	@ApiModelProperty(value = "Full name of the Student", example = "Juan Dela Cruz")
	private String name;
	
}
