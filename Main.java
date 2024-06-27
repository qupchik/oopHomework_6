// Комментарии по рефакторингу:

// Класс Main выполняет слишком много ответственностей: создание экземпляров сервисов, представлений, контроллеров, учителей, студентов и групп студентов.
// Эти ответственности следует разделить на несколько классов или методов, чтобы соблюдать принцип единственной ответственности (SRP).
// Можно создать отдельный класс, ответственный за конфигурацию и создание экземпляров сервисов, представлений и контроллеров.
// Создание учителей, студентов и групп студентов можно вынести в отдельные методы или классы.

// Вместо создания экземпляров конкретных классов (StudentService, TeacherService, StudentView, TeacherView) следует использовать интерфейсы (UserService, UserView).
// Это позволит соблюдать принцип программирования на уровне интерфейсов и принцип инверсии зависимостей (DIP).

// Вместо создания экземпляров сервисов, представлений и контроллеров внутри Main, лучше использовать механизм внедрения зависимостей.

// Логику создания учителей, студентов и групп студентов следует вынести из Main в соответствующие классы или методы.
// Это улучшит модульность и поддерживаемость кода, а также соблюдение принципа единственной ответственности (SRP).

// Для упрощения кода и избавления от дублирования следует рассмотреть возможность выделения вспомогательных методов.

import controller.StudentController;
import controller.StudentGroupController;
import controller.TeacherController;
import data.Student;
import data.Teacher;
import service.StudentGroupService;
import service.StudentService;
import service.TeacherService;
import view.StudentView;
import view.TeacherView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем сервисы
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        StudentGroupService studentGroupService = new StudentGroupService();

        // Создаем представления
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();

        // Создаем контроллеры
        StudentController studentController = new StudentController(studentService, studentView);
        TeacherController teacherController = new TeacherController(teacherService, teacherView);
        StudentGroupController studentGroupController = new StudentGroupController(studentGroupService, studentView);

        // Создаем учителей
        teacherController.create("Иван", "Иванов", "Иванович", LocalDate.of(1980, 5, 15));
        teacherController.create("Петр", "Петров", "Петрович", LocalDate.of(1975, 8, 25));
        teacherController.create("Анна", "Сидорова", "Ивановна", LocalDate.of(1985, 3, 10));
        teacherController.create("Мария", "Павлова", "Сергеевна", LocalDate.of(1970, 10, 5));
        teacherController.create("Сергей", "Смирнов", "Александрович", LocalDate.of(1990, 12, 20));

        // Создаем студентов
        studentController.create("Петр", "Петров", "Петрович", LocalDate.of(2000, 3, 10));
        studentController.create("Анна", "Сидорова", "Ивановна", LocalDate.of(2001, 8, 20));
        studentController.create("Мария", "Иванова", "Петровна", LocalDate.of(1999, 12, 5));
        studentController.create("Иван", "Смирнов", "Алексеевич", LocalDate.of(2002, 6, 15));
        studentController.create("Елена", "Козлова", "Андреевна", LocalDate.of(2000, 9, 20));

        // Получаем списки студентов и учителей
        List<Student> students = studentService.getAll();
        List<Teacher> teachers = teacherService.getAll();

        // Создаем группы студентов для каждого учителя
        List<Student> group1Students = new ArrayList<>();
        group1Students.add(students.get(0));
        group1Students.add(students.get(1));
        group1Students.add(students.get(2));
        studentGroupController.createStudentGroup(teachers.get(0), group1Students);

        List<Student> group2Students = new ArrayList<>();
        group2Students.add(students.get(3));
        group2Students.add(students.get(4));
        studentGroupController.createStudentGroup(teachers.get(1), group2Students);

        // Выводим информацию о группах студентов
        System.out.println("Информация о учителях и группах студентов:\n");
        Teacher teacher1 = teachers.get(0);
        System.out.println("Группа учителя " + teacher1.getFirstName() + " " + teacher1.getSecondName() + ":");
        studentGroupController.getSortedListStudentFromStudentGroup();

        Teacher teacher2 = teachers.get(1);
        System.out.println("Группа учителя " + teacher2.getFirstName() + " " + teacher2.getSecondName() + ":");
        studentGroupController.getSortedListStudentFromStudentGroup();

        // Выводим информацию о всех учителях
        System.out.println("Список всех учителей:");
        for (Teacher teacher : teachers) {
            teacherView.sendOnConsole(teacher);
        }
    }
}