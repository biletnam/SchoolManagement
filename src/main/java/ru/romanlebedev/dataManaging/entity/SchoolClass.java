package ru.romanlebedev.dataManaging.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RomanLebedev on 30.05.2017.
 */

@Entity
@Table(name = "SCHOOLCLASS")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    @OneToMany(mappedBy = "studentClass")
    private List<Student> students;

    @ManyToOne()
    @JoinColumn(name="SCHOOLID")
    private School school;

    @OneToOne
    @JoinColumn(name="TEACHERID")
    private Teacher classTeacher;

    @OneToOne
    @JoinColumn(name="JOURNALID")
    private Journal journal;

    public SchoolClass() {
    }

    public SchoolClass(String className , School school , Teacher teacher , Journal journal) {
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolClass that = (SchoolClass) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (classTeacher != null ? !classTeacher.equals(that.classTeacher) : that.classTeacher != null) return false;
        return journal != null ? journal.equals(that.journal) : that.journal == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (classTeacher != null ? classTeacher.hashCode() : 0);
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "className='" + className + '\'' +
                '}';
    }
}
