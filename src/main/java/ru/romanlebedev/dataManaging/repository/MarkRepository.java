package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    List<Mark> findMarksByStudentAndSubject(Student student ,
                                      Subject subject);
    List<Mark> findMarksByStudent(Student student);

    @Query(value = "SELECT AVG(VALUE) FROM MARK \n" +
            "WHERE MARK.STUDENTID = ?1 " , nativeQuery = true)
    Double findAverageMarkByStudent(String studentId);

    @Query(value = "SELECT AVG(VALUE) FROM MARK \n" +
            "WHERE MARK.STUDENTID = ?1 AND MARK.SUBJECTID = ?2" , nativeQuery = true)
    Double findAverageMarkByStudentAndSubject(String studentId , String subjectId);
}
