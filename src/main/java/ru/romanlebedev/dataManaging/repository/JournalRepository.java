package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.Journal;
import ru.romanlebedev.dataManaging.entity.SchoolClass;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface JournalRepository extends JpaRepository<Journal , Long> {
    List<Journal> findJournalsByClassOwner(SchoolClass schoolClass);
}