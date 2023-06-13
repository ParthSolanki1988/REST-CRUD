package com.simform.student.Controller;

import com.simform.student.Entity.Student;
import com.simform.student.Service.StudentService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@RestController
public class StudentController {
  @Autowired
  StudentService studentService;

//  CREAT STUDENT
  @RequestMapping("/students")
  public Student addStudent(@RequestBody Student student){
    return studentService.saveStudent(student);
  }

//  DELETE STUDENT

  @DeleteMapping("/students/delete/{id}")
  public String deleteStudent(@PathVariable long id){
    return studentService.deletedStudent(id);
  }

  //READ STUDENT DATA

  @GetMapping("/students")
  public List<Student> findAllStudents(){
    return studentService.getStudents();
  }

  //UPDATE STUDENT

  @PutMapping("/update")
  public Student updatedStudent(@RequestBody Student student){
    return studentService.updateStudent(student);
  }




}
