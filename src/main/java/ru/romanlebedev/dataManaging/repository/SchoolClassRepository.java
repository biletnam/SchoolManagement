package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.School;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.entity.Teacher;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    List<SchoolClass> findBySchool(School school);

}
