package ru.romanlebedev.dataManaging.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.repository.StudentRepository;
import ru.romanlebedev.dataManaging.service.interfaces.StudentService;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getBySchoolClass(SchoolClass schoolClass) {
        return studentRepository.findStudentsByStudentClass(schoolClass);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
