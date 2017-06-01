package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.Journal;
import ru.romanlebedev.dataManaging.entity.Mark;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.entity.Subject;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findMarksByJournalAndStudentAndSubject(Journal journal ,
                                                      Student student ,
                                                      Subject subject);
}
