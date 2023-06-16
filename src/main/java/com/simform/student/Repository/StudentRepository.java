package com.simform.student.Repository;

import com.simform.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * @JpaReposiotry : Spring Data JPA will automatically create the implementation for the Repository interface.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

}
