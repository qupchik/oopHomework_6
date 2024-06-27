package controller;

import data.Student;
import service.StudentService;
import view.StudentView;

import java.time.LocalDate;
import java.util.List;

// Контроллер для работы со студентами
public class StudentController implements UserController<Student> {

    // Применяем принцип инверсии зависимостей (DIP)
    private final StudentService studentService;
    private final StudentView studentView;

    public StudentController(StudentService studentService, StudentView studentView) {
        this.studentService = studentService;
        this.studentView = studentView;
    }

    // // Сервис для работы с данными о студентах
    // private final StudentService dataService = new StudentService();
    // // Сервис для работы с группами студентов
    // private final StudentGroupService studentGroupService = new
    // StudentGroupService();
    // // Представление для студентов
    // private final StudentView studentView = new StudentView();

    // Метод создания студента
    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Student student = studentService.create(firstName, secondName, patronymic, dateOfBirth);
        studentView.sendOnConsole(List.of(student));
    }
}

// // Метод создания студента
// @Override
// public void create(String firstName, String secondName, String patronymic,
// LocalDate dateOfBirth) {
// dataService.create(firstName, secondName, patronymic, dateOfBirth);
// studentView.sendOnConsole(dataService.getAll());
// }

// // Метод создания группы студентов
// public void createStudentGroup(Teacher teacher, List<Student> students) {
// studentGroupService.createStudentGroup(teacher, students);
// studentView.sendOnConsoleUserGroup(studentGroupService.getStudentGroup());
// }

// // Метод получения студента из группы по имени и фамилии
// public void getStudentInStudentGroup(String firstName, String secondName) {
// Student student = studentGroupService.getStudentFromStudentGroup(firstName,
// secondName);
// studentView.sendOnConsole(Collections.singletonList(student));
// }

// // Метод получения отсортированного списка студентов из группы
// public void getSortedListStudentFromStudentGroup() {
// List<Student> students = studentGroupService.getSortedStudentGroup();
// studentView.sendOnConsole(students);
// }

// // Метод получения отсортированного списка студентов из группы по ФИО
// public void getSortedListByFIOStudentFromStudentGroup() {
// List<Student> students = studentGroupService.getSortedByFIOStudentGroup();
// studentView.sendOnConsole(students);
// }
// }