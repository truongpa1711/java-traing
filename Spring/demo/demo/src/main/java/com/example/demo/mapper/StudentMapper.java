package com.example.demo.mapper;

import com.example.demo.dto.CourseEnrollmentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // MapStruct sẽ tạo một Spring Bean để bạn có thể @Autowired mapper này
public interface StudentMapper {

    /**
     * Ánh xạ từ entity Student sang DTO StudentDto.
     * studentCourses (List<StudentCourse>) sẽ được ánh xạ sang courses (List<CourseEnrollmentDto>).
     * MapStruct sẽ tự động lặp qua danh sách studentCourses và gọi toCourseEnrollmentDto() cho từng phần tử.
     */
    @Mapping(source = "studentCourses", target = "courses")
    StudentDto studentToStudentDto(Student student);

    /**
     * Ánh xạ từ StudentCourse entity sang CourseEnrollmentDto.
     * Dữ liệu của Course (course.id, course.title, course.description) sẽ được ánh xạ vào CourseEnrollmentDto.
     * enrollmentDate được lấy trực tiếp từ StudentCourse.
     *
     * Ví dụ:
     *   studentCourse.getCourse().getId()            -> id
     *   studentCourse.getCourse().getTitle()         -> title
     *   studentCourse.getCourse().getDescription()   -> description
     *   studentCourse.getEnrollmentDate()            -> enrollmentDate
     */
    @Mapping(target = "id", source = "course.id")                   // Lấy course.id -> gán vào CourseEnrollmentDto.id
    @Mapping(target = "title", source = "course.title")             // Lấy course.title -> gán vào CourseEnrollmentDto.title
    @Mapping(target = "description", source = "course.description") // Lấy course.description -> gán vào CourseEnrollmentDto.description
    @Mapping(target = "enrollmentDate", source = "enrollmentDate")  // Lấy enrollmentDate từ StudentCourse -> gán vào CourseEnrollmentDto.enrollmentDate
    CourseEnrollmentDto toCourseEnrollmentDto(StudentCourse studentCourse);
}
