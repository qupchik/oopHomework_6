// В классе Teacher мы удалили вложенный класс TeacherComparator, поскольку это нарушало принцип единственной ответственности (SRP). Вместо этого используем общий компаратор UserComparator из пакета util.

package data;

import java.time.LocalDate;

// Класс учителя, наследуется от пользователя и реализует Comparable
public class Teacher extends User implements Comparable<Teacher> {
    private Long teacherId;

    public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        super(firstName, secondName, patronymic, dateOfBirth);
    }

    public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, Long teacherId) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + getFirstName() + '\'' +
                ", secondName='" + getSecondName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                '}';
    }

    // Переопределение метода compareTo для сравнения по идентификатору учителя
    @Override
    public int compareTo(Teacher o) {
        return this.teacherId.compareTo(o.teacherId);
    }
}

// public static class TeacherComparator implements Comparator<Teacher> {
// @Override
// public int compare(Teacher o1, Teacher o2) {
// int result = o1.getSecondName().compareTo(o2.getSecondName());
// if (result == 0) {
// result = o1.getFirstName().compareTo(o2.getFirstName());
// if (result == 0) {
// return o1.getPatronymic().compareTo(o2.getPatronymic());
// } else {
// return result;
// }
// } else {
// return result;
// }
// }
// }
// }