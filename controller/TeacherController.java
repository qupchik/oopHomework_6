// Аналогично StudentController, в этом файле внедрили зависимости от TeacherService и TeacherView через конструктор, применив принцип инверсии зависимостей (DIP). Также  использовали интерфейс UserController для создания учителей, что улучшает расширяемость и соответствует принципу открытости/закрытости (OCP).

package controller;

import data.Teacher;
import service.TeacherService;
import view.TeacherView;

import java.time.LocalDate;

// Контроллер для работы с учителями
public class TeacherController implements UserController<Teacher> {

    // Применяем принцип инверсии зависимостей (DIP)
    private final TeacherService teacherService;
    private final TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    // Метод создания учителя
    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Teacher teacher = teacherService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(teacher);
    }
}

// // Сервис для работы с данными о учителях
// private final TeacherService dataService = new TeacherService();
// // Представление для учителей
// private final TeacherView teacherView = new TeacherView();

// // Метод создания учителя
// @Override
// public void create(String firstName, String secondName, String patronymic,
// LocalDate dateOfBirth) {
// dataService.create(firstName, secondName, patronymic, dateOfBirth);
// teacherView.sendOnConsole(dataService.getAll());
// }
// }