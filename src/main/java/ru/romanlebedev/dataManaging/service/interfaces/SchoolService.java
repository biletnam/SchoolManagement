package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.School;
import ru.romanlebedev.dataManaging.entity.School;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface SchoolService {
    School addSchool(School school);
    void deleteSchool(Long id);
    School editSchool(School school);
    List<School> getAllSchools();
}
