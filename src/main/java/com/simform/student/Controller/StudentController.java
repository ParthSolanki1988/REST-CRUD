package com.simform.student.Controller;

import com.simform.student.Entity.Student;
import com.simform.student.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")

public class StudentController {

  StudentService studentService;

  // build create User REST API

  //  CREAT
  @PostMapping
  public ResponseEntity<Student> createStudents(@RequestBody Student student){
    Student saveStudent = studentService.createStudent(student);
    return new ResponseEntity<>(saveStudent , HttpStatus.CREATED);
  }

  //READ

  // build get user by id REST API
  // http://localhost:8080/api/v1/students
  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents(){
    List<Student> listOfStudent = studentService.getAllStudents();
    return new ResponseEntity<>(listOfStudent , HttpStatus.OK );
  }


  //UPDATE

  // http://localhost:8080/api/v1/students/101
  @PutMapping("{id}")
  public ResponseEntity<Student> updatedStudent(@PathVariable("id") Long id,@RequestBody Student student){
    student.setId(id);
    Student updateStudents = studentService.updateStudent(student);
    return new ResponseEntity<>(updateStudents , HttpStatus.OK);
  }


  // DELETE

  // http://localhost:8080/api/v1/students/101
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable long id){
    studentService.deleteStudent(id);
    return new ResponseEntity<>("Delete Student Successfully!" , HttpStatus.OK);
  }


}
