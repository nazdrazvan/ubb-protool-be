package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.dto.UniversityClassDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityClassService {
    void createUniversityClass(UniversityClassDTO universityClassDTO );

    void deleteUniversityClass(int universityClassId);

    void updateUniversityClass(UniversityClassDTO universityClassDTO);

    List<UniversityClassDTO> findAllUniversityClasses();

    UniversityClassDTO findById(int id);
}
