// В интерфейсе UserView изменили метод sendOnConsole для вывода отдельного пользователя на консоль.

package view;

import data.User;

// import java.util.List;

// Интерфейс представления для пользователей
public interface UserView<T extends User> {
    // Метод отправки пользователя на консоль
    // void sendOnConsole(List<T> list);
    void sendOnConsole(T user);
}
