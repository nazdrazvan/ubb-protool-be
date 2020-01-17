//package com.chk.ubbprotool.ubbprotool.Service;
//
//import com.chk.ubbprotool.ubbprotool.DTO.StudentDTO;
//import com.chk.ubbprotool.ubbprotool.Model.UniversityClass;
//import com.chk.ubbprotool.ubbprotool.Repository.UniversityClassRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
//public class UniversityClassServiceImpl implements UniversityClassService{
//
//    @Autowired
//    private UniversityClassRepository universityClassRepository;
//
//    @Autowired
//    private UniversityClassMapper universityClassMapper;
//
//
//    @Override
//    @Transactional
//    public void createUniversityClass(UniversityClassDTO universityClassDTO) {
//        UniversityClass univ = universityClassMapper.toEntity(universityClassDTO);
//        universityClassRepository.saveData(univ);
//    }
//
//    @Override
//    @Transactional
//    public void deleteUniversityClass(int universityClassId) {
//        universityClassRepository.removeData(universityClassId);
//    }
//
//    @Override
//    @Transactional
//    public void updateUniversityClass(UniversityClassDTO universityClassDTO) {
//        UniversityClass univ = universityClassMapper.toEntity(universityClassDTO);
//        universityClassRepository.saveData(univ);
//    }
//
//    @Override
//    @Transactional
//    public List<UniversityClassDTO> findAllUniversityClasses() {
//        List<UniversityClassDTO> univDtoList = new ArrayList<UniversityClassDTO>();
//        for (UniversityClass univ : universityClassRepository.findAll() )
//        {
//            UniversityClassDTO universityClassDTO = universityClassMapper.toDTO(univ) ;
//            univDtoList.add(universityClassDTO);
//        }
//        return univDtoList;
//    }
//
//    @Override
//    @Transactional
//    public UniversityClassDTO findById(int id) {
//        return null;
//    }
//}
