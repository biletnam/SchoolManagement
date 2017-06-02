package ru.romanlebedev.dataManaging.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RomanLebedev on 30.05.2017.
 */

@Entity
@Table(name = "JOURNAL")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String journalName;

    @OneToOne(mappedBy="journal")
    private SchoolClass classOwner;

    @OneToMany(mappedBy = "journal")
    private List<Mark> marks;

    public Journal() {
    }

    public Journal(String journalName, SchoolClass classOwner) {
        this.journalName = journalName;
        this.classOwner = classOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public SchoolClass getClassOwner() {
        return classOwner;
    }

    public void setClassOwner(SchoolClass classOwner) {
        this.classOwner = classOwner;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journal journal = (Journal) o;

        if (id != null ? !id.equals(journal.id) : journal.id != null) return false;
        if (journalName != null ? !journalName.equals(journal.journalName) : journal.journalName != null) return false;
        return classOwner != null ? classOwner.equals(journal.classOwner) : journal.classOwner == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (journalName != null ? journalName.hashCode() : 0);
        result = 31 * result + (classOwner != null ? classOwner.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return journalName;
    }
}
