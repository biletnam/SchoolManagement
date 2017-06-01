package ru.romanlebedev.dataManaging.entity;

import javax.persistence.*;

/**
 * Created by RomanLebedev on 30.05.2017.
 */
@Entity
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name="SUBJECTID")
    private Subject subject;

    @OneToOne(mappedBy="classTeacher")
    private SchoolClass teacherClass;

    public Teacher() {
    }

    public Teacher(String firstname, String lastname, Subject subject) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
    }

    public Teacher(String firstname, String lastname, Subject subject, SchoolClass teacherClass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
        this.teacherClass = teacherClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SchoolClass getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(SchoolClass teacherClass) {
        this.teacherClass = teacherClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != null ? !id.equals(teacher.id) : teacher.id != null) return false;
        if (firstname != null ? !firstname.equals(teacher.firstname) : teacher.firstname != null) return false;
        if (lastname != null ? !lastname.equals(teacher.lastname) : teacher.lastname != null) return false;
        if (subject != null ? !subject.equals(teacher.subject) : teacher.subject != null) return false;
        return teacherClass != null ? teacherClass.equals(teacher.teacherClass) : teacher.teacherClass == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (teacherClass != null ? teacherClass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
