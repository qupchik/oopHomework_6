// В процессе рефакторинга я переименовал файл
// src\controller\StudentGroupService.java в
// src/controller/StudentGroupController.java.
// Это было сделано для соблюдения принципа единственной ответственности (SRP).
// В исходном коде класс StudentGroupService имел две ответственности:
// управление группами студентов и сортировку студентов. Логика сортировки была
// перенесена в сервис StudentGroupService, а контроллер получил название
// StudentGroupController и стал отвечать только за управление группами
// студентов.

// package controller;

// import data.Student;
// import data.StudentGroup;
// import data.Teacher;
// import data.UserComparator;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Iterator;
// import java.util.List;

// // Сервис для работы с группами студентов
// public class StudentGroupService {
// // Группа студентов
// private StudentGroup studentGroup;

// // Метод создания группы студентов
// public void createStudentGroup(Teacher teacher, List<Student> students) {
// this.studentGroup = new StudentGroup(teacher, students);
// }

// // Метод получения группы студентов
// public StudentGroup getStudentGroup() {
// return studentGroup;
// }

// // Метод получения студента из группы по имени и фамилии
// public Student getStudentFromStudentGroup(String firstName, String
// secondName) {
// Iterator<Student> iterator = studentGroup.iterator();
// List<Student> result = new ArrayList<>();
// while (iterator.hasNext()) {
// Student student = iterator.next();
// if (student.getFirstName().equalsIgnoreCase(firstName)
// && student.getSecondName().equalsIgnoreCase(secondName)) {
// result.add(student);
// }
// }
// if (result.size() == 0) {
// throw new IllegalStateException(
// String.format("Студент с именем %s и фамилией %s не найден", firstName,
// secondName));
// }
// if (result.size() != 1) {
// throw new IllegalStateException("Найдено более одного студента с указанными
// именем и фамилией");
// }
// return result.get(0);
// }

// // Метод получения отсортированного списка студентов из группы
// public List<Student> getSortedStudentGroup() {
// List<Student> students = new ArrayList<>(studentGroup.getStudents());
// Collections.sort(students);
// return students;
// }

// // Метод получения отсортированного списка студентов из группы по ФИО
// public List<Student> getSortedByFIOStudentGroup() {
// List<Student> students = new ArrayList<>(studentGroup.getStudents());
// students.sort(new UserComparator<>());
// return students;
// }
// }