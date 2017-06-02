package ru.romanlebedev.dataManaging.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RomanLebedev on 30.05.2017.
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @ManyToOne()
    @JoinColumn(name="CLASSID")
    private SchoolClass studentClass;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    public Student() {
    }

    public Student(String firstname, String lastname, SchoolClass studentClass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentClass = studentClass;
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

    public SchoolClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(SchoolClass studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (firstname != null ? !firstname.equals(student.firstname) : student.firstname != null) return false;
        if (lastname != null ? !lastname.equals(student.lastname) : student.lastname != null) return false;
        return studentClass != null ? studentClass.equals(student.studentClass) : student.studentClass == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (studentClass != null ? studentClass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
