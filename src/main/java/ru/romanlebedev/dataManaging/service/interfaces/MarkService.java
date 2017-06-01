package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.*;

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
    Mark editMark(Mark mark);
    List<Mark> getAllMarks();
}
