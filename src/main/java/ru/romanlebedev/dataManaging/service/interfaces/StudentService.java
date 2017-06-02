package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Student;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface StudentService {
    Student addStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getBySchoolClass(SchoolClass schoolClass);
    Student editStudent(Student student);
    List<Student> getAllStudents();
}
