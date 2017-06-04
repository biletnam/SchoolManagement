//package ru.romanlebedev;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import ru.romanlebedev.dataManaging.entity.*;
//import ru.romanlebedev.dataManaging.service.interfaces.*;
//import ru.romanlebedev.factory.abstractFactory.AbstractFactory;
//
//@SpringBootApplication
//public class SchoolmanagementApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SchoolmanagementApplication.class, args);
//	}
//
//	@Bean
//	public CommandLineRunner loadData(JournalService journalService,
//									  MarkService markService,
//									  SchoolClassService schoolClassService,
//									  SchoolService schoolService,
//									  StudentService studentService,
//									  SubjectService subjectService,
//									  TeacherService teacherService,
//									  AbstractFactory schoolFactory) {
//		return (args) -> {
///*
//* Создание и добавление учеников с помощью Фабрики и сервиса для работы с базой данных
//*
//* */
////			for (SchoolClass schoolClass:schoolClassService.getAllSchoolClasses()) {
////				for(int i = 0 ; i < 10 ; i++){
////					Student student = schoolFactory.createStudent();
////					student.setStudentClass(schoolClass);
////					studentService.addStudent(student);
////				}
////			}
//
///*
//* Создание и добавление оценок учеников с помощью фабрики и сервиса для работа с базой данных
//*
//* */
//			for (SchoolClass schoolClass:schoolClassService.getAllSchoolClasses()) {
//				for (Student student:studentService.getBySchoolClass(schoolClass)) {
//					for (Subject subject:subjectService.getAllSubjects()) {
//						for(int i = 0 ; i < 20 ; i++){
//							Mark mark = schoolFactory.createMark();
//							mark.setStudent(student);
//							mark.setSubject(subject);
//							mark.setJournal(schoolClass.getJournal());
//							markService.addMark(mark);
//						}
//					}
//				}
//			}
//
//		};
//	}
//}
