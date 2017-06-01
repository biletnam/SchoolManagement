package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByTeacherClass(SchoolClass schoolClass);
    Teacher findBySubject(Subject subject);
}
