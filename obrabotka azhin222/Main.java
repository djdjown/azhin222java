import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;

public class DateTimeTasks {
    public static void main(String[] args) {
        // 1. Текущая дата и время
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущая дата: " + currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Текущее время: " + currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        // 2. Сравнение дат
        System.out.println(compareDates(LocalDate.of(2025, 2, 1), LocalDate.of(2025, 2, 10)));

        // 3. Дни до Нового года
        System.out.println("Дней до Нового года: " + daysUntilNewYear());

        // 4. Проверка високосного года
        System.out.println("2024 - високосный? " + isLeapYear(2024));

        // 5. Подсчет выходных за месяц
        System.out.println("Выходных в месяце 2/2025: " + countWeekends(2025, 2));

        // 6. Измерение времени выполнения
        System.out.println("Время выполнения (мс): " + measureExecutionTime(() -> {
            for (int i = 0; i < 1_000_000; i++);
        }));

        // 7. Форматирование и парсинг даты
        System.out.println("Новая дата: " + parseAndFormatDate("06-02-2025"));

        // 8. Конвертация между часовыми поясами
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("Время в Москве: " + convertTimeZone(utcTime, "Europe/Moscow"));

        // 9. Вычисление возраста
        System.out.println("Возраст: " + calculateAge(LocalDate.of(2000, 2, 6)));

        // 10. Календарь на месяц
        printMonthCalendar(2025, 2);

        // 11. Генерация случайной даты
        System.out.println("Случайная дата: " + generateRandomDate(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31)));

        // 12. Время до события
        System.out.println("До события осталось: " + timeUntil(LocalDateTime.of(2025, 12, 31, 23, 59, 59)));

        // 13. Рабочие часы
        System.out.println("Рабочих часов: " + calculateWorkHours(LocalDateTime.of(2025, 2, 6, 9, 0), LocalDateTime.of(2025, 2, 6, 18, 0)));

        // 14. Форматирование даты с локалью
        System.out.println("Дата на русском: " + formatDateWithLocale(LocalDate.of(2025, 2, 6), new Locale("ru")));

        // 15. День недели
        System.out.println("День недели: " + getDayOfWeek(LocalDate.of(2025, 2, 6)));
    }

    public static String compareDates(LocalDate date1, LocalDate date2) {
        return date1.isBefore(date2) ? "Первая дата раньше" : date1.isAfter(date2) ? "Первая дата позже" : "Обе даты равны";
    }

    public static long daysUntilNewYear() {
        LocalDate newYear = LocalDate.of(LocalDate.now().getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(LocalDate.now(), newYear);
    }

    public static boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }

    public static long countWeekends(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        long weekends = 0;
        while (date.getMonthValue() == month) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends++;
            }
            date = date.plusDays(1);
        }
        return weekends;
    }

    public static long measureExecutionTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        return (System.nanoTime() - start) / 1_000_000;
    }

    public static LocalDate parseAndFormatDate(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy")).plusDays(10);
    }

    public static ZonedDateTime convertTimeZone(ZonedDateTime time, String zoneId) {
        return time.withZoneSameInstant(ZoneId.of(zoneId));
    }

    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printMonthCalendar(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        while (date.getMonthValue() == month) {
            System.out.println(date + " - " + (date.getDayOfWeek().getValue() >= 6 ? "Выходной" : "Рабочий день"));
            date = date.plusDays(1);
        }
    }

    public static LocalDate generateRandomDate(LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        return start.plusDays(new Random().nextInt((int) days + 1));
    }

    public static Duration timeUntil(LocalDateTime eventTime) {
        return Duration.between(LocalDateTime.now(), eventTime);
    }

    public static long calculateWorkHours(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.HOURS.between(start, end);
    }

    public static String formatDateWithLocale(LocalDate date, Locale locale) {
        return date.format(DateTimeFormatter.ofPattern("d MMMM yyyy", locale));
    }

    public static String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new Locale("ru"));
    }
}
