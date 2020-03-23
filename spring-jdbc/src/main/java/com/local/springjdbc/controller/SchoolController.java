package com.local.springjdbc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.local.springjdbc.dto.Student;
import com.local.springjdbc.dto.request.NewStudent;
import com.local.springjdbc.dto.request.UpdateStudent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "School", tags = {"school"})
public interface SchoolController {

	@ApiOperation(value = "Add new Student", notes = "Add new Student in the System. See the schema of the parameter for more information.", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Student has been successfully added."),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<Void> addNewStudent(
		@ApiParam(
			name = "NewStudent",
			value = "A JSON value for adding a new Student",
			required = true)
		NewStudent student);
	
	@ApiOperation(value = "Update Student", notes = "Update a Student in the System. See the schema of the parameter for more information.", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Student has been successfully updated."),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<Void> updateStudent(
		@ApiParam(
				name = "UpdateStudent",
				value = "A JSON value for updating a Student.",
				required = true)
		UpdateStudent student);
	
	@ApiOperation(value = "Delete by Record ID", notes = "Delete a Student in the System using record ID.", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Student has been successfully deleted."),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<Void> deleteStudentById(@ApiParam(value="Record ID of the Student", required=true) long id);
	
	@ApiOperation(value = "Delete by Student ID", notes = "Delete a Student in the System using Student ID.", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Student has been successfully deleted."),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<Void> deleteStudentByStudentId(@ApiParam(value="Student's unique ID", required=true) String studentId);
	
	@ApiOperation(value = "Find by Record ID", notes = "Find student data using record ID.", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully fetched Student"),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 404, message = "Student not found."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<Student> findStudentById(@ApiParam(value="Record ID of the Student", required=true) long id);
	
	@ApiOperation(value = "Find by Student ID", notes = "Find student data using Student ID.", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully fetched Student"),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 404, message = "Student not found."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<Student> findStudentByStudentId(@ApiParam(value="Student's unique ID", required=true) String studentId);
	
	@ApiOperation(value = "Find all Students", notes = "Find all Students in the System", tags={ "school" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully fetched Students"),
        @ApiResponse(code = 400, message = "Unable to process your request."),
        @ApiResponse(code = 404, message = "No record(s) found."),
        @ApiResponse(code = 415, message = "The content type is unsupported"),
        @ApiResponse(code = 500, message = "An unexpected error has been occurred.") })
	public ResponseEntity<List<Student>> findAllStudents();
	
}
