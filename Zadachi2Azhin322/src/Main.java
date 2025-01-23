import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {

    // 1. Нахождение максимума
    public static int max(int a, int b) throws IllegalArgumentException {
        if (a == b) {
            throw new IllegalArgumentException("Числа равны.");
        }
        return Math.max(a, b);
    }

    // 2. Калькулятор деления
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return a / b;
    }

    // 3. Конвертер строк в числа
    public static int stringToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    // 4. Проверка возраста
    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть в диапазоне от 0 до 150.");
        }
    }

    // 5. Нахождение корня
    public static double sqrt(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным.");
        }
        return Math.sqrt(number);
    }

    // 6. Факториал
    public static long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 7. Проверка массива на нули
    public static void checkArrayForZeros(int[] array) throws IllegalArgumentException {
        for (int num : array) {
            if (num == 0) {
                throw new IllegalArgumentException("Массив содержит нули.");
            }
        }
    }

    // 8. Калькулятор возведения в степень
    public static double power(double base, int exponent) throws IllegalArgumentException {
        if (exponent < 0) {
            throw new IllegalArgumentException("Показатель степени не может быть отрицательным.");
        }
        return Math.pow(base, exponent);
    }

    // 9. Обрезка строки
    public static String truncate(String str, int length) throws IllegalArgumentException {
        if (length > str.length()) {
            throw new IllegalArgumentException("Длина больше длины строки.");
        }
        return str.substring(0, length);
    }

    // 10. Поиск элемента в массиве
    public static int findElement(int[] array, int element) throws IllegalArgumentException {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        throw new IllegalArgumentException("Элемент не найден.");
    }

    // 11. Конвертация в двоичную систему
    public static String toBinary(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным.");
        }
        return Integer.toBinaryString(number);
    }

    // 12. Проверка делимости
    public static boolean isDivisible(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return a % b == 0;
    }

    // 13. Чтение элемента списка
    public static <T> T getElementAt(List<T> list, int index) throws IndexOutOfBoundsException {
        return list.get(index);
    }

    // 14. Парольная проверка
    public static void validatePassword(String password) throws IllegalArgumentException {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Пароль слишком слабый.");
        }
    }

    // 15. Проверка даты
    public static void validateDate(String date) throws IllegalArgumentException {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты.");
        }
    }

    // 16. Конкатенация строк
    public static String concatenate(String str1, String str2) throws NullPointerException {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("Одна из строк равна null.");
        }
        return str1 + str2;
    }

    // 17. Остаток от деления
    public static int remainder(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return a % b;
    }

    // 18. Квадратный корень
    public static double squareRoot(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным.");
        }
        return Math.sqrt(number);
    }

    // 19. Конвертер температуры
    public static double celsiusToFahrenheit(double celsius) throws IllegalArgumentException {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Температура ниже абсолютного нуля.");
        }
        return celsius * 9 / 5 + 32;
    }

    // 20. Проверка строки на пустоту
    public static void validateString(String str) throws IllegalArgumentException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Строка пуста или равна null.");
        }
    }

    // Пример использования
    public static void main(String[] args) {
        try {
            System.out.println(max(10, 20)); // 20
            System.out.println(divide(10, 2)); // 5.0
            System.out.println(stringToInt("123")); // 123
            validateAge(25); // No exception
            System.out.println(sqrt(16)); // 4.0
            System.out.println(factorial(5)); // 120
            checkArrayForZeros(new int[]{1, 2, 3}); // No exception
            System.out.println(power(2, 3)); // 8.0
            System.out.println(truncate("Hello, world!", 5)); // Hello
            System.out.println(findElement(new int[]{1, 2, 3}, 2)); // 1
            System.out.println(toBinary(10)); // 1010
            System.out.println(isDivisible(10, 2)); // true
            System.out.println(celsiusToFahrenheit(0)); // 32.0
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
