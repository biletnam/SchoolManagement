package ru.romanlebedev.factory.abstractFactory;

import ru.romanlebedev.dataManaging.entity.Mark;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;

/**
 * Created by RomanLebedev on 04.06.2017.
 */
public abstract class AbstractFactory {
    public abstract Student createStudent();
    public abstract Teacher createTeacher();
    public abstract Subject createSubject();
    public abstract Mark createMark();
}
