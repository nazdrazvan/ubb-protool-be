package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Repository.TeacherRepository;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import com.chk.ubbprotool.ubbprotool.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void createTeacher(TeacherDTO teacher) {
        teacherRepository.saveData(teacherMapper.toEntity(teacher));
    }

    @Override
    public void deleteTeacher(int teacherId) {
        teacherRepository.removeData(teacherId);
    }

    @Override
    public void upgradeTeacher(TeacherDTO teacher) {
        teacherRepository.saveData(teacherMapper.toEntity(teacher));
    }

    @Override
    public List<TeacherDTO> findAllTeachers() {
        List<TeacherDTO> teacherDTOList = new ArrayList<TeacherDTO>();

        for (Teacher teacher : teacherRepository.findAll() )
        {
            TeacherDTO teacherDTO = teacherMapper.toDTO(teacher) ;
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    @Override
    public TeacherDTO findById(int id) {
        Teacher teacher = teacherRepository.findById(id);
        return teacherMapper.toDTO(teacher);
    }
}
