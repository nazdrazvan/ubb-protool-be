package com.chk.ubbprotool.ubbprotool.mapper;

import com.chk.ubbprotool.ubbprotool.Repository.CourseRepository;
import com.chk.ubbprotool.ubbprotool.Repository.SubgroupRepository;
import com.chk.ubbprotool.ubbprotool.Repository.TeacherRepository;
import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import com.chk.ubbprotool.ubbprotool.Model.Course;
import com.chk.ubbprotool.ubbprotool.Model.Subgroup;
import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversityClassMapper {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubgroupRepository subgroupRepository;

    public UniversityClass toEntity(UniversityClassDTO universityClassDTO)
    {
        UniversityClass result = new UniversityClass();

        result.setClassId(universityClassDTO.getClassId());
        result.setClassDay(universityClassDTO.getClassDay());
        result.setClassDuration(universityClassDTO.getClassDuration());
        result.setClassHour(universityClassDTO.getClassHour());
        result.setClassLocation(universityClassDTO.getClassLocation());
        result.setClassType(universityClassDTO.getClassType());
        result.setClassWeek(universityClassDTO.getClassWeek());
        Course c = courseRepository.findById(universityClassDTO.getCourseId());
        result.setCourse(c);
        Teacher t = teacherRepository.findById(universityClassDTO.getTeacherId());
        result.setTeacher(t);
        Subgroup s = subgroupRepository.findById(universityClassDTO.getSubgroupId());
        result.setSubgroup(s);

        return result;

    }

    public UniversityClassDTO toDTO(UniversityClass universityClass)
    {
        UniversityClassDTO result = new UniversityClassDTO();

        result.setClassId(universityClass.getClassId());
        result.setClassDay(universityClass.getClassDay());
        result.setClassDuration(universityClass.getClassDuration());
        result.setClassHour(universityClass.getClassHour());
        result.setClassLocation(universityClass.getClassLocation());
        result.setClassType(universityClass.getClassType());
        result.setClassWeek(universityClass.getClassWeek());
        result.setCourseId(universityClass.getCourse().getCourseId());
        result.setTeacherId(universityClass.getTeacher().getTeacherId());
        result.setSubgroupId(universityClass.getSubgroup().getSubgroupId());

        return result;
    }

}
