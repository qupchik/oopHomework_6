// В классе TeacherView реализовали интерфейс UserView для вывода учителей на консоль.

package view;

import data.Student;
import data.Teacher;

import java.util.List;
import java.util.logging.Logger;

public class TeacherView implements UserView<Teacher> {

    private static final Logger logger = Logger.getLogger(TeacherView.class.getName());

    // Метод вывода учителя на консоль
    @Override
    public void sendOnConsole(Teacher teacher) {
        logger.info(teacher.toString());
    }

    public void sendOnConsole(List<Student> students, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendOnConsole'");
    }
}