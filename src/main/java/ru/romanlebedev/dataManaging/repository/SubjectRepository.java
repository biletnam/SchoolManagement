package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByTeacher(Teacher teacher);
}
