package com.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.beans.Student;

@RestController
@ResponseBody
public class StudentController {
	
/*	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1,"Akanksha",49.99f);
	} */
	
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student s = new Student(1,"Akanksha",49.99f); 
//		return new ResponseEntity<>(s,HttpStatus.OK);
		return ResponseEntity.ok().header("customheader", "Akanksha").body(s);
	}
	
	@GetMapping("/studentlist")
	public List<Student> getStudentList() {
		
		List<Student> studentList = new ArrayList();
		
		Student s2 = new Student(2,"Divyanshi",45.55f);
		Student s3 = new Student(3,"Khyati",48.58f);
		Student s4 = new Student(4,"Pihu",40.58f);
		
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		return studentList;
		
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return new Student(8,"Priya",35.45f);
	}
	
	@GetMapping("/student/{id}/{fname}/{lname}")
	public Student getStudentByIdname(@PathVariable("id") int id,@PathVariable("fname") String fname,@PathVariable("lname") String lname) {
		return new Student(8,"Aashi",35.45f);
	}

	@GetMapping("/studentbyid/")
	public Student getStudentByIdReq(@RequestParam int id) {
		Student obj = new Student(10, "Chinu", 45.50f);
		return obj;

	}
	
	@PostMapping("/student/create")
	public Student createStudent(@RequestBody Student s) {
		System.out.println("Student object received from post "+s);
		return s;
	}

	@PutMapping("/student/update/{id}")
	public Student updateStudent(@RequestBody Student s,@PathVariable int id) {
		System.out.println("Student object updated from put "+s);
		return s;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public boolean deleteStudent(@PathVariable("id") int id) {
		return true;
	}
}
