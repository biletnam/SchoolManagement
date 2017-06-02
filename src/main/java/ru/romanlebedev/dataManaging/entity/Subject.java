package ru.romanlebedev.dataManaging.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RomanLebedev on 30.05.2017.
 */
@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;

    @OneToOne(mappedBy="subject")
    private Teacher teacher;

    @OneToMany(mappedBy = "subject")
    private List<Mark> marks;

    public Subject() {
    }

    public Subject(String subjectName, Teacher teacher) {
        this.subjectName = subjectName;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (id != null ? !id.equals(subject.id) : subject.id != null) return false;
        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        return teacher != null ? teacher.equals(subject.teacher) : subject.teacher == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
