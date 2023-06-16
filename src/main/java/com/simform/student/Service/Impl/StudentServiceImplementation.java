package com.simform.student.Service.Impl;

import com.simform.student.Entity.Student;
import com.simform.student.Repository.StudentRepository;
import com.simform.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImplementation implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public Student createStudent(Student student) {
    return studentRepository.save(student);

  }

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();

  }

  @Override
  public Student updateStudent(Student student) {
    Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
    if (student.getId() == 0 ){
      student.setId(existingStudent.getId());

    }
    if (student.getName() == "" || student.getName() == null){
      student.setName(existingStudent.getName());

    }
    if (student.getTechnology() == "" || student.getTechnology() == null){
      student.setTechnology(existingStudent.getTechnology());

    }
    existingStudent.setId(student.getId());
    existingStudent.setName(student.getName());
    existingStudent.setTechnology(student.getTechnology());

    return studentRepository.save(existingStudent);

  }

  @Override
  public String deleteStudent(long id) {
    if (!studentRepository.existsById(id)){
      return "Student Id Not found";
    }
    else {
      studentRepository.deleteById(id);
      return "Student Removed with ID : " + id;
    }

  }
}
