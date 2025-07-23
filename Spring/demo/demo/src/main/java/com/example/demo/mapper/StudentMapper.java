package com.example.demo.mapper;

import com.example.demo.dto.CourseEnrollmentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // MapStruct sẽ tạo một Spring Bean để bạn có thể @Autowired mapper này
public interface StudentMapper {

    @Mapping(source = "studentCourses", target = "courses")
    StudentDto studentToStudentDto(Student student);


    @Mapping(target = "id", source = "course.id")                   // Lấy course.id -> gán vào CourseEnrollmentDto.id
    @Mapping(target = "title", source = "course.title")             // Lấy course.title -> gán vào CourseEnrollmentDto.title
    @Mapping(target = "description", source = "course.description") // Lấy course.description -> gán vào CourseEnrollmentDto.description
    @Mapping(target = "enrollmentDate", source = "enrollmentDate")  // Lấy enrollmentDate từ StudentCourse -> gán vào CourseEnrollmentDto.enrollmentDate
    CourseEnrollmentDto toCourseEnrollmentDto(StudentCourse studentCourse);
}
