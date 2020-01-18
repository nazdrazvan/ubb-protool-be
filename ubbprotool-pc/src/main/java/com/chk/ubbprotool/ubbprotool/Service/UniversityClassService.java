package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
import com.chk.ubbprotool.ubbprotool.dto.ChangeDTO;
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

    UniversityClassDTO findById(Long id);

    List<UniversityClassDTO> getClassesForStudent(Long studentDTO, Date currentDate, List<ChangeDTO> changes) throws Exception;
    List<UniversityClassDTO> getClassesForTeacher(Long teacherDTO, Date currentDate);

    List<StudentDTO> findAllStudentsByClassId(Long classId);

    List<UniversityClassDTO> getPossibleClassesToBeChanged(Long classId, Date currentDate);


}
