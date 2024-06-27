package view;

import data.Student;

import java.util.logging.Logger;

// Представление для студентов
public class StudentView implements UserView<Student> {

    // Логгер
    private static final Logger logger = Logger.getLogger(StudentView.class.getName());

    // Метод вывода студента на консоль
    @Override
    public void sendOnConsole(Student student) {
        logger.info(student.toString());
    }

    public void sendOnConsole(Iterable<Student> students) {
        for (Student student : students) {
            logger.info(student.toString());
        }
    }
}