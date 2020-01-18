package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.dto.StudentDTO;
import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
public interface UniversityClassService {
    void createUniversityClass(UniversityClassDTO universityClassDTO );

    void deleteUniversityClass(int universityClassId);

    void updateUniversityClass(UniversityClassDTO universityClassDTO);

    List<UniversityClassDTO> findAllUniversityClasses();

    UniversityClassDTO findById(int id);

    List<UniversityClassDTO> getClassesForStudent(int studentDTO, Date currentDate);

    List<UniversityClassDTO> getClassesForTeacher(int teacherDTO, Date currentDate);

}
