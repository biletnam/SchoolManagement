package ru.romanlebedev.dataManaging.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.School;
import ru.romanlebedev.dataManaging.repository.SchoolRepository;
import ru.romanlebedev.dataManaging.service.interfaces.SchoolService;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.delete(id);
    }

    @Override
    public School editSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}
