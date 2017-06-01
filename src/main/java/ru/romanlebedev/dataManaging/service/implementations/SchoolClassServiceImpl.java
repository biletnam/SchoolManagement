package ru.romanlebedev.dataManaging.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.School;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.repository.MarkRepository;
import ru.romanlebedev.dataManaging.repository.SchoolClassRepository;
import ru.romanlebedev.dataManaging.service.interfaces.SchoolClassService;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Override
    public SchoolClass addSchoolClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public void deleteSchoolClass(Long id) {
        schoolClassRepository.delete(id);
    }

    @Override
    public List<SchoolClass> getBySchool(School school) {
        return schoolClassRepository.findBySchool(school);
    }

    @Override
    public SchoolClass editSchoolClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    @Override
    public List<SchoolClass> getAllSchoolClasses() {
        return schoolClassRepository.findAll();
    }
}
