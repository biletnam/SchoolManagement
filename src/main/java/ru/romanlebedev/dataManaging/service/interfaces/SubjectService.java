package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface SubjectService {
    Subject addSubject(Subject subject);
    void deleteSubject(Long id);
    Subject getByTeacher(Teacher teacher);
    Subject editSubject(Subject subject);
    List<Subject> getAllSubjects();
}
