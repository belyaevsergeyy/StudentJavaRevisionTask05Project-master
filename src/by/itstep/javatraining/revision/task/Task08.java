package by.itstep.javatraining.revision.task;

/*	Task 08. Next Date [дата следующего дня]
 *
 *  Заданы три целых числа d, m и y, которые задают некоторую дату по Грегорианскому календарю.
 *  Определите дату следующего дня.
 *
 *	Примечание
 *	1) Постарайтесь не использовать стандартную библиотеку работы со временем
 *  (задание закрепляет знания по использованию именно условных конструкций).
 *  2) Не забудьте про "защиту от дурака": все данные должны быть корректными.
 *  3) Отсчёт года идёт с нуля (наша эра), т.е. не должно быть отрицательного года.
 *
 *	Формат входных данных [input]
 *	На вход даются три целых числа в диапазоне int.
 *
 *	Формат выходных данных [output]
 *	Должна быть возвращена строка с соответствующей датой следующего дня в формате "DD.MM.YYYY"
 *  или "Error.", если данные введены некорректно.
 *
 *	[ input 1]: 3 5 2023
 *	[output 1]: 04.05.2023
 *
 *	[ input 2]: 28 2 2023
 *	[output 2]: 01.03.2023
 *
 *	[ input 3]: 28 2 2020
 *	[output 3]: 29.02.2020
 *
 *	[ input 4]: 30 2 2020
 *	[output 4]: Error.
 *
 *	[ input 5]: 1 13 2020
 *	[output 5]: Error.
 *
 *	[ input 6]: 1 1 -1
 *	[output 6]: Error.
 *
 *	[ input 7]: 1 1 1
 *	[output 7]: 02.01.0001
 */

public class Task08 {
    public static String task08(int day, int month, int year) {
        int maxDay = month == 4 || month == 6 || month == 9 || month == 11 ? 30 : 31;
        int maxDayFebr = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
        if (month == 2 && day > maxDayFebr || day < 1 || day > maxDay || month < 1 || month > 12 || year < 0) {
            return "Error.";
        }

        if (month == 2 && day == maxDayFebr || day == maxDay) {
            day = 1;
            if (month == 12) {
                month = 1;
                ++year;
            } else {
                ++month;
            }
        } else {
            ++day;
        }

        return String.format("%02d." + "%02d." + "%04d", day, month, year);
    }
}