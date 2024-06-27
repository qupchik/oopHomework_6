// перенесли компаратор UserComparator в отдельный пакет util

// package data;

// import java.util.Comparator;

// // Компаратор для сравнения пользователей по ФИО
// public class UserComparator<T extends User> implements Comparator<T> {

// // Метод сравнения
// @Override
// public int compare(T o1, T o2) {
// int resultOfComparing = o1.getSecondName().compareTo(o2.getSecondName());
// if (resultOfComparing == 0) {
// resultOfComparing = o1.getFirstName().compareTo(o2.getFirstName());
// if (resultOfComparing == 0) {
// return o1.getPatronymic().compareTo(o2.getPatronymic());
// } else {
// return resultOfComparing;
// }
// } else {
// return resultOfComparing;
// }
// }
// }
