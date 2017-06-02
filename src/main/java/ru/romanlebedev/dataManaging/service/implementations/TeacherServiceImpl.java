package ru.romanlebedev.dataManaging.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;
import ru.romanlebedev.dataManaging.repository.TeacherRepository;
import ru.romanlebedev.dataManaging.service.interfaces.TeacherService;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.delete(id);
    }

    @Override
    public Teacher getBySubject(Subject subject) {
        return teacherRepository.findBySubject(subject);
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
