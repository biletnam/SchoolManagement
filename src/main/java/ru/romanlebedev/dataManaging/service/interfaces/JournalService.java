package ru.romanlebedev.dataManaging.service.interfaces;

import ru.romanlebedev.dataManaging.entity.Journal;
import ru.romanlebedev.dataManaging.entity.SchoolClass;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface JournalService {
    Journal addJournal(Journal journal);
    void deleteJournal(Long id);
    Journal editJournal(Journal journal);
    List<Journal> getAllJournals();
}
