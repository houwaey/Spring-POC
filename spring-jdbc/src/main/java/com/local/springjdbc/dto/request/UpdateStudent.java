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
public class UpdateStudent implements Serializable {

	@ApiModelProperty(value = "Record ID", example = "1001")
	private long id;
	
	@ApiModelProperty(value = "Full name of the Student", example = "Juan Dela Cruz")
	private String name;
	
}
