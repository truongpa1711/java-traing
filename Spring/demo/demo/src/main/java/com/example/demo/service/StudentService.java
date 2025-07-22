package com.example.demo.service;

import com.example.demo.dto.CourseEnrollmentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCourse;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

//    public StudentDto convertToDto(Student student) {
//        StudentDto dto = new StudentDto();
//        dto.setId(student.getId());
//        dto.setName(student.getName());
//
//        List<CourseEnrollmentDto> courseDtos = student.getStudentCourses().stream()
//                .map(sc -> {
//                    Course c = sc.getCourse();
//                    CourseEnrollmentDto cdto = new CourseEnrollmentDto();
//                    cdto.setId(c.getId());
//                    cdto.setTitle(c.getTitle());
//                    cdto.setDescription(c.getDescription());
//                    cdto.setEnrollmentDate(sc.getEnrollmentDate()); // <-- lấy từ bảng trung gian
//                    return cdto;
//                }).toList();
//
//        dto.setCourses(courseDtos);
//        return dto;
//    }


//    public List<?> getAllStudents() {
//        return studentRepository.findAll();
//    }
    public Page<Student> getAllStudents(int page, int size, String keyword, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
            Sort.by(sortBy).ascending() :
            Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page-1, size, sort);
        return studentRepository.searchStudents(keyword, pageable);
    }

    public Page<StudentDto> getAllStudents_v1(int page, int size, String keyword, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
            Sort.by(sortBy).ascending() :
            Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page-1, size, sort);
        return studentRepository.searchStudents_v1(keyword, pageable);
    }



    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public boolean enrollStudentInCourse(Long studentId, Long courseId) {
        System.out.println("Enrolling student with ID: " + studentId + " in course with ID: " + courseId);
            Student student = studentRepository.findById(studentId).orElse(null);
            Course course = courseRepository.findById(courseId).orElse(null);

            if (student != null && course != null) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudent(student);
                studentCourse.setCourse(course);
                studentCourse.setEnrollmentDate(java.time.LocalDate.now());
                studentCourseRepository.save(studentCourse);
                return true;
            }
        return false;
    }



}
