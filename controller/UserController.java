// Этот интерфейс остался без изменений, но его использование в контроллерах StudentController и TeacherController улучшает расширяемость и соответствует принципу открытости/закрытости (OCP).

package controller;

import data.User;

import java.time.LocalDate;

// Интерфейс для контроллеров пользователей
public interface UserController<T extends User> {
    // Метод создания пользователя
    void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}