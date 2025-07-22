package com.example.demo.repository;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<Student> findByEmail(String email);

    @Query(value = "SELECT * FROM student " +
            "WHERE (:keyword IS NULL OR " +
            "LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(email) LIKE LOWER(CONCAT('%', :keyword, '%')))",

            countQuery = "SELECT COUNT(*) FROM student " +
                    "WHERE (:keyword IS NULL OR " +
                    "LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                    "LOWER(email) LIKE LOWER(CONCAT('%', :keyword, '%')))",
            nativeQuery = true)
    Page<Student> searchStudents(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT new com.example.demo.dto.StudentDto(s.id, s.name, s.email, s.username) " +
            "FROM Student s " +
            "WHERE (:keyword IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+"lower(s.email)like LOWER(CONCAT('%', :keyword, '%')))")
    Page<StudentDto> searchStudents_v1(@Param("keyword") String keyword, Pageable pageable);


}