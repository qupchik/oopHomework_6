// В классе StudentGroupService заменили использование итератора на обычный цикл for-each для получения студента по имени и фамилии, так как это более читаемо и понятно. Кроме того, перенесли компаратор UserComparator в отдельный пакет util.

package service;

import data.Student;
import data.StudentGroup;
import data.Teacher;
import util.UserComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Сервис для работы с группами студентов
public class StudentGroupService {
    // Группа студентов
    private StudentGroup studentGroup;

    // Метод создания группы студентов
    public void createStudentGroup(Teacher teacher, List<Student> students) {
        this.studentGroup = new StudentGroup(teacher, students);
    }

    // Метод получения группы студентов
    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    // Метод получения студента из группы по имени и фамилии
    // public Student getStudentFromStudentGroup(String firstName, String
    // secondName) {
    // List<Student> result = new ArrayList<>();
    // for (Student student : studentGroup.getStudents()) {
    // if (student.getFirstName().equalsIgnoreCase(firstName)
    // && student.getSecondName().equalsIgnoreCase(secondName)) {
    // result.add(student);
    // }
    // }
    // if (result.isEmpty()) {
    // throw new IllegalStateException(
    // String.format("Студент с именем %s и фамилией %s не найден", firstName,
    // secondName));
    // }
    // if (result.size() > 1) {
    // throw new IllegalStateException("Найдено более одного студента с указанными
    // именем и фамилией");
    // }
    // return result.get(0);
    // }

    public List<Student> getStudentFromStudentGroup(String firstName, String secondName) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentGroup.getStudents()) {
            if (student.getFirstName().equalsIgnoreCase(firstName)
                    && student.getSecondName().equalsIgnoreCase(secondName)) {
                result.add(student);
            }
        }
        if (result.isEmpty()) {
            throw new IllegalStateException(
                    String.format("Студент с именем %s и фамилией %s не найден", firstName, secondName));
        }
        return result;
    }

    // Метод получения отсортированного списка студентов из группы
    public List<Student> getSortedStudentGroup() {
        List<Student> students = new ArrayList<>(studentGroup.getStudents());
        Collections.sort(students);
        return students;
    }

    // Метод получения отсортированного списка студентов из группы по ФИО
    public List<Student> getSortedByFIOStudentGroup() {
        List<Student> students = new ArrayList<>(studentGroup.getStudents());
        students.sort(new UserComparator<>());
        return students;
    }
}
