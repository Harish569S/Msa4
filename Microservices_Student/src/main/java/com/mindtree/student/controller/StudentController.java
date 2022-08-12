package com.mindtree.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.student.entity.Student;
import com.mindtree.student.service.StudentService;
import com.mindtree.student.vo.College;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StudentService studentService;
	
	
	
    @PostMapping
	public String  addStudent(@RequestBody  Student student) {
    	
    	int collegeId=student.getColId();
    	College college=restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+collegeId, College.class);
    	int totalStudents=restTemplate.getForObject("http://COLLEGE-SERVICE/college/noOfStudents/"+collegeId, Integer.class);
    	int presentStudents=studentService.getpresentStudents(collegeId);
    	if(college==null ) {
    		return "No college of such id found";
    	}
    	
  	else if(totalStudents <= presentStudents) {
 		return "Total numbers of students limit reached";	
	   }
    	
    	return studentService.addStud(student);
    		
	}
       

    
    
    @GetMapping("/name-in-asc/{id}")
    public List<Student> gealltStudentByNames(@PathVariable int id){
    	return studentService.getByName(id);
    }
    
    
    @GetMapping("/age-in-desc/{str}")
    public List<Student> gealltStudentByAge(@PathVariable String str){
    	return studentService.getByAge(str);
    }
    
    
}
