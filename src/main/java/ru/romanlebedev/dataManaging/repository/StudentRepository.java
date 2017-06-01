package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Student;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface StudentRepository extends JpaRepository<Student , Long> {
    List<Student> findStudentsByStudentClass(SchoolClass schoolClass);
}
