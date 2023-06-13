package com.simform.student.Service;

import com.simform.student.Entity.Student;
import com.simform.student.Repository.StudentRepository;
import com.simform.student.StudentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class StudentService {
  @Autowired StudentRepository studentRepository;

  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  public String deletedStudent(long id){
    studentRepository.deleteById(id);
    return "Student Removed with ID : " + id;
  }

  public List<Student> getStudents(){
    return studentRepository.findAll();
  }

  public Student updateStudent(Student student){

    Student existingStudent = studentRepository.findById(student.getId()).orElse(null);

    existingStudent.setId(student.getId());
    existingStudent.setName(student.getName());
    existingStudent.setTechnology(student.getTechnology());

    return studentRepository.save(existingStudent);
  }

}
