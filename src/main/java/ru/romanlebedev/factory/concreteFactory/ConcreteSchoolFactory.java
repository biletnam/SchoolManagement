package ru.romanlebedev.factory.concreteFactory;

import org.springframework.stereotype.Service;
import ru.romanlebedev.dataManaging.entity.Mark;
import ru.romanlebedev.dataManaging.entity.Student;
import ru.romanlebedev.dataManaging.entity.Subject;
import ru.romanlebedev.dataManaging.entity.Teacher;
import ru.romanlebedev.factory.abstractFactory.AbstractFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by RomanLebedev on 04.06.2017.
 */
@Service
public class ConcreteSchoolFactory extends AbstractFactory {

    private List<String> listOfFirstNames;
    private List<String> listOfTeachersFirstNames;
    private List<String> listOfLastNames;
    private List<String> listOfTeachersLastNames;
    private List<String> listOfSubjects;
    private Random randomGenerator;
    private GregorianCalendar gregorianCalendar;

    public ConcreteSchoolFactory() {
        gregorianCalendar = new GregorianCalendar();
        randomGenerator = new Random();
        initialize();
    }

    @Override
    public Student createStudent() {
        String firstname = listOfFirstNames.get(randomGenerator.nextInt(listOfFirstNames.size()));
        String lastname = listOfLastNames.get(randomGenerator.nextInt(listOfLastNames.size()));
        return new Student(firstname , lastname);
    }

    @Override
    public Teacher createTeacher() {
        String firstname = listOfTeachersFirstNames.get(randomGenerator.nextInt(listOfTeachersFirstNames.size()));
        String lastname = listOfTeachersLastNames.get(randomGenerator.nextInt(listOfTeachersLastNames.size()));
        return new Teacher(firstname , lastname);
    }

    @Override
    public Subject createSubject() {
        String subjectName = listOfSubjects.get(randomGenerator.nextInt(listOfSubjects.size()));
        return new Subject(subjectName);
    }

    @Override
    public Mark createMark() {
        Mark mark = new Mark();
        mark.setValue(ThreadLocalRandom.current().nextInt(2, 6));
        Integer year  = 2016;
        GregorianCalendar newGregCal = new GregorianCalendar(
                year,
                randomGenerator.nextInt(12),
                randomGenerator.nextInt(30)
        );
        mark.setDate(newGregCal.getTime());
        return mark;
    }

    private void initialize(){
        listOfFirstNames = new ArrayList<>();
        listOfFirstNames.add("Андрей");
        listOfFirstNames.add("Арсений");
        listOfFirstNames.add("Геннадий");
        listOfFirstNames.add("Дмитрий");
        listOfFirstNames.add("Константин");
        listOfFirstNames.add("Степан");
        listOfFirstNames.add("Ярослав");
        listOfFirstNames.add("Никита");
        listOfFirstNames.add("Иван");
        listOfFirstNames.add("Евгений");
        listOfLastNames = new ArrayList<>();
        listOfLastNames.add("Денисов");
        listOfLastNames.add("Дроздов");
        listOfLastNames.add("Казаков");
        listOfLastNames.add("Казаков");
        listOfLastNames.add("Марков");
        listOfLastNames.add("Русаков");
        listOfLastNames.add("Савельев");
        listOfLastNames.add("Щукин");
        listOfLastNames.add("Соболев");
        listOfLastNames.add("Озеров");
        listOfTeachersFirstNames = new ArrayList<>();
        listOfTeachersFirstNames.add("Любовь");
        listOfTeachersFirstNames.add("Ирина");
        listOfTeachersFirstNames.add("Светлана");
        listOfTeachersFirstNames.add("Елена");
        listOfTeachersFirstNames.add("Мария");
        listOfTeachersLastNames = new ArrayList<>();
        listOfTeachersLastNames.add("Петрова");
        listOfTeachersLastNames.add("Иванова");
        listOfTeachersLastNames.add("Казакова");
        listOfTeachersLastNames.add("Афанасьева");
        listOfTeachersLastNames.add("Мартынова");
        listOfSubjects = new ArrayList<>();
        listOfSubjects.add("История");
        listOfSubjects.add("Биология");
        listOfSubjects.add("Английский язык");
        listOfSubjects.add("Физкультура");
        listOfSubjects.add("Обществознание");
        listOfSubjects.add("Химия");
    }
}
