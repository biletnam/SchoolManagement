//package ru.romanlebedev;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import ru.romanlebedev.dataManaging.entity.Journal;
//import ru.romanlebedev.dataManaging.entity.SchoolClass;
//import ru.romanlebedev.dataManaging.entity.Subject;
//import ru.romanlebedev.dataManaging.entity.Teacher;
//import ru.romanlebedev.dataManaging.service.interfaces.*;
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
//									  TeacherService teacherService) {
//		return (args) -> {
//			for (Teacher teacher:
//			teacherService.getAllTeachers()) {
//				System.out.println("Имя : " + teacher.getFirstname() + ", Фамилия : " + teacher.getLastname());
//			}
//
//			for (Journal journal:
//				 journalService.getAllJournals()) {
//				System.out.println(journal);
//			}
//
//			for (SchoolClass schoolClass:
//				 schoolClassService.getAllSchoolClasses()) {
//				System.out.println(schoolClass);
//			}
//
//			for (Subject subject:
//				 subjectService.getAllSubjects()) {
//				System.out.println(subject);
//			}
//		};
//	}
//}
