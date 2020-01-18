package com.chk.ubbprotool.ubbprotool.Service;

import com.chk.ubbprotool.ubbprotool.Model.Teacher;
import com.chk.ubbprotool.ubbprotool.Repository.TeacherRepository;
import com.chk.ubbprotool.ubbprotool.dto.TeacherDTO;
import com.chk.ubbprotool.ubbprotool.dto.TeacherForEditDTO;
import com.chk.ubbprotool.ubbprotool.mapper.TeacherForEditMapper;
import com.chk.ubbprotool.ubbprotool.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.chk.ubbprotool.ubbprotool")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherForEditMapper teacherForEditMapper;

    @Override
    @Transactional
    public void createTeacher(TeacherDTO teacher) {
        teacherRepository.saveData(teacherMapper.toEntity(teacher));
    }

    @Override
    @Transactional
    public void deleteTeacher(Long teacherId) {
        teacherRepository.removeData(teacherId);
    }

    @Override
    @Transactional
    public void editTeacher(TeacherForEditDTO teacher) {
        teacherRepository.updateData(teacherForEditMapper.toEntity(teacher));
    }

    @Override
    @Transactional
    public List<TeacherDTO> findAllTeachers() {
        List<TeacherDTO> teacherDTOList = new ArrayList<TeacherDTO>();

        for (Teacher teacher : teacherRepository.findAll()) {
            TeacherDTO teacherDTO = teacherMapper.toDTO(teacher);
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    @Override
    @Transactional
    public TeacherDTO findById(Long id) {
        Teacher teacher = teacherRepository.findById(id);
        if (teacher == null) {
            return null;
        }
        return teacherMapper.toDTO(teacher);
    }

    @Override
    @Transactional
    public TeacherDTO findTeacherByEmailAndPassword(String email, String password) {
        Teacher teacher = teacherRepository.findByEmailAndPassword(email, password);
        if (teacher == null) {
            return null;
        }
        return teacherMapper.toDTO(teacher);
    }

    @Override
    @Transactional
    public void activateTeacher(TeacherDTO teach) throws Exception {
        Teacher newTeacher = teacherMapper.toEntity(teach);
        int result = teacherRepository.activateTeacher(newTeacher);
        if (result == 0) {
            throw new Exception("The teacher is not in the university system!");
        }
    }
}
