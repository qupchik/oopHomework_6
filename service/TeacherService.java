// В классе TeacherService также использовали интерфейс UserService для реализации метода create и применили лямбда-выражение и метод stream для получения максимального идентификатора учителя.

package service;

import data.Teacher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {

    private final List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Teacher create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = teachers.stream()
                .mapToLong(Teacher::getTeacherId)
                .max()
                .orElse(0L) + 1;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        teachers.add(teacher);
        return teacher;
    }

}

// @Override
// public void create(String firstName, String secondName, String patronymic,
// LocalDate dateOfBirth) {
// Long countMaxId = 0L;
// for (Teacher teacher : teachers) {
// if (teacher.getTeacherId() > countMaxId) {
// countMaxId = teacher.getTeacherId();
// }
// }
// countMaxId++;
// Teacher teacher = new Teacher(firstName, secondName, patronymic,
// dateOfBirth);
// teacher.setTeacherId(countMaxId);
// teachers.add(teacher);
// }
// }
