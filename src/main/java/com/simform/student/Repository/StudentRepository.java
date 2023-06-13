package com.simform.student.Repository;

import com.simform.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

  List<Student> findAllById(Long id);
}
