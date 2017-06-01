package ru.romanlebedev.dataManaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.romanlebedev.dataManaging.entity.School;

/**
 * Created by RomanLebedev on 31.05.2017.
 */
public interface SchoolRepository extends JpaRepository<School, Long> {
}
