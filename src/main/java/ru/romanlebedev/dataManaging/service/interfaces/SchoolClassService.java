package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.*;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface SchoolClassService {
    SchoolClass addSchoolClass(SchoolClass schoolClass);
    void deleteSchoolClass(Long id);
    List<SchoolClass> getBySchool(School school);
    SchoolClass editSchoolClass(SchoolClass schoolClass);
    List<SchoolClass> getAllSchoolClasses();
}
