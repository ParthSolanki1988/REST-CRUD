package com.simform.student.Service;

import com.simform.student.Entity.Student;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface StudentService {

   Student createStudent(Student student);

   List<Student> getAllStudents();

   Student updateStudent(Student student);

   String deleteStudent(long id);





}
