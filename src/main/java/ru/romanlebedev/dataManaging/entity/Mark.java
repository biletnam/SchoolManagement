package ru.romanlebedev.dataManaging.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RomanLebedev on 31.05.2017.
 */

@Entity
@Table(name = "MARK")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="JOURNALID")
    private Journal journal;

    @ManyToOne()
    @JoinColumn(name="STUDENTID")
    private Student student;

    @ManyToOne()
    @JoinColumn(name="SUBJECTID")
    private Subject subject;

    private Integer value;
    private Date date;

    public Mark() {
    }

    public Mark(Journal journal, Student student, Subject subject, Integer value, Date date) {
        this.journal = journal;
        this.student = student;
        this.subject = subject;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark = (Mark) o;

        if (id != null ? !id.equals(mark.id) : mark.id != null) return false;
        if (journal != null ? !journal.equals(mark.journal) : mark.journal != null) return false;
        if (student != null ? !student.equals(mark.student) : mark.student != null) return false;
        if (subject != null ? !subject.equals(mark.subject) : mark.subject != null) return false;
        if (value != null ? !value.equals(mark.value) : mark.value != null) return false;
        return date != null ? date.equals(mark.date) : mark.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
