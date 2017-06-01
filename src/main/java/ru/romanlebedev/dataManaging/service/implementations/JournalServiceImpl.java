package ru.romanlebedev.dataManaging.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.Journal;
import ru.romanlebedev.dataManaging.entity.SchoolClass;
import ru.romanlebedev.dataManaging.repository.JournalRepository;
import ru.romanlebedev.dataManaging.service.interfaces.JournalService;

import java.util.List;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
@Service
public class JournalServiceImpl implements JournalService{

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public void deleteJournal(Long id) {
        journalRepository.delete(id);
    }

    @Override
    public List<Journal> getBySchoolClass(SchoolClass schoolClass) {
        return journalRepository.findJournalsByClassOwner(schoolClass);
    }

    @Override
    public Journal editJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
}
