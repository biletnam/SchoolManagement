package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    Teacher getBySchoolClass(SchoolClass schoolClass);
    Teacher getBySubject(Subject subject);
    Teacher editTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
}
