package data;

import java.util.Iterator;
import java.util.List;

// Итератор для группы студентов
public class StudentGroupIterator implements Iterator<Student> {

    // Счетчик и список студентов
    private int counter;
    private final List<Student> students;

    // Конструктор
    public StudentGroupIterator(StudentGroup studentGroup) {
        this.students = studentGroup.getStudents();
        this.counter = 0;
    }

    // Проверка на наличие следующего элемента
    @Override
    public boolean hasNext() {
        return counter < students.size() - 1;
    }

    // Получение следующего элемента
    @Override
    public Student next() {
        if (!hasNext()) {
            return null;
        }
        counter++;
        return students.get(counter);
    }
}