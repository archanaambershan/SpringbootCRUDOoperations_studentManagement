package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.Student;
import java.util.*;
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentRepository stdrepo;
	
	//get all student value
	@GetMapping("/studentList")
	public List<Student> getAllStudent(){
		return stdrepo.findAll();
	}
    
	//create student data
	@PostMapping("/addStudent")
	public Student createStudent(@RequestBody Student student) {
		return stdrepo.save(student);
	}
	
	//getStudent by id
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentByid(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		Student st=stdrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student is notavailable"));
	   return ResponseEntity.ok().body(st);
	}
	
	//update data
	
	@PutMapping("/upadtestudent/{id}")
	public ResponseEntity<Student> changeData(@PathVariable(value="id") Long id,@RequestBody Student st) throws ResourceNotFoundException {
		
		Student stu=stdrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student is not available"));
		 stu.setName(st.getName());
		 stu.setLname(st.getLname());
		 stu.setMailid(st.getMailid());
		 stdrepo.save(stu);
		 return ResponseEntity.ok().body(stu);
		 
	}
	//delete data
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		Student s=stdrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("student is not available"));
		 stdrepo.deleteById(id);  
		 return ResponseEntity.ok().build();
	}
	
}
