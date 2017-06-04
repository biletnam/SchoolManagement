package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.Journal;
import ru.romanlebedev.dataManaging.entity.Mark;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.entity.Subject;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface MarkService {
    Mark addMark(Mark mark);
    void deleteMark(Long id);
    List<Mark> getByJournalAndStudentAndSubject(Journal journal ,
                                                Student student ,
                                                Subject subject);
    List<Mark> getByStudentAndSubject(Student student ,
                                      Subject subject);
    List<Mark> getByStudent(Student student);
    Mark editMark(Mark mark);
    List<Mark> getAllMarks();
    Double getAverageMarkByStudent(String studentId);
    Double getAverageMarkBySubject(String subjectId);
    Double getAverageMarkByStudentAndSubject(String studentId , String subjectId);
}
