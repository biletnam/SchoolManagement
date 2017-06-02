package ru.romanlebedev.dataManaging.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.Journal;
import ru.romanlebedev.dataManaging.entity.Mark;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.repository.MarkRepository;
import ru.romanlebedev.dataManaging.service.interfaces.MarkService;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Override
    public Mark addMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public void deleteMark(Long id) {
        markRepository.delete(id);
    }

    @Override
    public List<Mark> getByJournalAndStudentAndSubject(Journal journal, Student student, Subject subject) {
        return markRepository.findMarksByJournalAndStudentAndSubject(journal , student , subject);
    }

    @Override
    public List<Mark> getByStudentAndSubject(Student student, Subject subject) {
        return markRepository.findMarksByStudentAndSubject(student , subject);
    }

    @Override
    public List<Mark> getByStudent(Student student) {
        return markRepository.findMarksByStudent(student);
    }

    @Override
    public Mark editMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    @Override
    public Double getAverageMarkByStudent(String studentId) {
        return markRepository.findAverageMarkByStudent(studentId);
    }

    @Override
    public Double getAverageMarkByStudentAndSubject(String studentId, String subjectId) {
        return markRepository.findAverageMarkByStudentAndSubject(studentId , subjectId);
    }
}
