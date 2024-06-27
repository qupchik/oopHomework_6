// В этом файле также применён принцип инверсии зависимостей (DIP), внедряя зависимости от StudentGroupService и StudentView через конструктор. Логика работы с группами студентов была вынесена из контроллера в сервис StudentGroupService, что соответствует принципу единственной ответственности (SRP).

package controller;

import data.Student;
import data.Teacher;
import service.StudentGroupService;
import view.StudentView;

// import java.util.Collections;
import java.util.List;

// Контроллер для работы с группами студентов
public class StudentGroupController {

    // Применяем принцип инверсии зависимостей (DIP)
    private final StudentGroupService studentGroupService;
    private final StudentView studentView;

    public StudentGroupController(StudentGroupService studentGroupService, StudentView studentView) {
        this.studentGroupService = studentGroupService;
        this.studentView = studentView;
    }

    // Метод создания группы студентов
    public void createStudentGroup(Teacher teacher, List<Student> students) {
        studentGroupService.createStudentGroup(teacher, students);
        studentView.sendOnConsole(studentGroupService.getStudentGroup().getStudents());
    }

    // Метод получения студента из группы по имени и фамилии
    // public void getStudentInStudentGroup(String firstName, String secondName) {
    // Student student = studentGroupService.getStudentFromStudentGroup(firstName,
    // secondName);
    // studentView.sendOnConsole(Collections.singletonList(student));
    // }

    public void getStudentInStudentGroup(String firstName, String secondName) {
        List<Student> students = studentGroupService.getStudentFromStudentGroup(firstName, secondName);
        if (students.size() > 1) {
            System.out.println("Найдено несколько студентов с указанными именем и фамилией:");
        }
        studentView.sendOnConsole(students);
    }

    // Метод получения отсортированного списка студентов из группы
    public void getSortedListStudentFromStudentGroup() {
        List<Student> students = studentGroupService.getSortedStudentGroup();
        studentView.sendOnConsole(students);
    }

    // Метод получения отсортированного списка студентов из группы по ФИО
    public void getSortedListByFIOStudentFromStudentGroup() {
        List<Student> students = studentGroupService.getSortedByFIOStudentGroup();
        studentView.sendOnConsole(students);
    }
}
