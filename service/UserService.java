// Интерфейс UserService остался без изменений.

package service;

import data.User;
import java.time.LocalDate;
import java.util.List;

// Интерфейс для сервисов пользователей
public interface UserService<T extends User> {
    // Метод получения всех пользователей
    List<T> getAll();

    // Метод создания пользователя
    T create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}