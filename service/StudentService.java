// В классе StudentService использовали интерфейс UserService для реализации метода create, чтобы соблюдать принцип инверсии зависимостей (DIP). Кроме того, использовали лямбда-выражение и метод stream для получения максимального идентификатора студента вместо циклического обхода списка.

package service;

import data.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Сервис для работы со студентами
public class StudentService implements UserService<Student> {

    // Список студентов
    private final List<Student> students;

    // Конструктор
    public StudentService() {
        this.students = new ArrayList<>();
    }

    // Метод получения всех студентов
    @Override
    public List<Student> getAll() {
        return students;
    }

    // Метод создания студента
    @Override
    public Student create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = students.stream()
                .mapToLong(Student::getStudentId)
                .max()
                .orElse(0L) + 1;
        Student student = new Student(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        students.add(student);
        return student;
    }
}

// // Метод создания студента
// @Override
// public void create(String firstName, String secondName, String patronymic,
// LocalDate dateOfBirth) {
// Long countMaxId = 0L;
// for (Student student : students) {
// if (student.getStudentId() > countMaxId) {
// countMaxId = student.getStudentId();
// }
// }
// countMaxId++;
// Student student = new Student(firstName, secondName, patronymic, dateOfBirth,
// countMaxId);
// students.add(student);
// }
// }