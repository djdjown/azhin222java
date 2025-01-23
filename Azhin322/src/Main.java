import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача 1: Четное или нечетное число
        System.out.print("Введите целое число (Задача 1): ");
        int num = scanner.nextInt();
        System.out.println(num % 2 == 0 ? "Четное" : "Нечетное");

        // Задача 2: Минимальное из трех чисел
        System.out.print("Введите три числа (Задача 2): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Минимальное: " + Math.min(a, Math.min(b, c)));

        // Задача 3: Таблица умножения на 5
        System.out.println("Таблица умножения на 5 (Задача 3):");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
        }

        // Задача 4: Сумма чисел от 1 до N
        System.out.print("Введите N (Задача 4): ");
        int n = scanner.nextInt();
        System.out.println("Сумма: " + (n * (n + 1) / 2));

        // Задача 5: Числа Фибоначчи
        System.out.print("Введите N для чисел Фибоначчи (Задача 5): ");
        n = scanner.nextInt();
        System.out.print("Числа Фибоначчи: ");
        int fib1 = 0, fib2 = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(fib1 + " ");
            int next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;
        }
        System.out.println();

        // Задача 6: Проверка простого числа
        System.out.print("Введите число (Задача 6): ");
        num = scanner.nextInt();
        boolean isPrime = num > 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Простое" : "Не простое");

        // Задача 7: Обратный порядок чисел
        System.out.print("Введите N (Задача 7): ");
        n = scanner.nextInt();
        System.out.print("Обратный порядок: ");
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Задача 8: Сумма четных чисел
        System.out.print("Введите A и B (Задача 8): ");
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int sum = 0;
        for (int i = Math.min(A, B); i <= Math.max(A, B); i++) {
            if (i % 2 == 0) sum += i;
        }
        System.out.println("Сумма четных чисел: " + sum);

        // Задача 9: Реверс строки
        System.out.print("Введите строку (Задача 9): ");
        scanner.nextLine(); // Очистка буфера
        String input = scanner.nextLine();
        System.out.println("Реверс строки: " + new StringBuilder(input).reverse());

        // Задача 10: Количество цифр в числе
        System.out.print("Введите число (Задача 10): ");
        num = scanner.nextInt();
        System.out.println("Количество цифр: " + String.valueOf(Math.abs(num)).length());

        // Задача 11: Факториал числа
        System.out.print("Введите N (Задача 11): ");
        n = scanner.nextInt();
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Факториал: " + factorial);

        // Задача 12: Сумма цифр числа
        System.out.print("Введите число (Задача 12): ");
        num = scanner.nextInt();
        sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println("Сумма цифр: " + sum);

        // Задача 13: Палиндром
        System.out.print("Введите строку (Задача 13): ");
        input = scanner.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(input.equals(reversed) ? "Палиндром" : "Не палиндром");

        // Задача 14: Максимальное число в массиве
        System.out.print("Введите размер массива (Задача 14): ");
        n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int max = array[0];
        for (int numInArray : array) {
            if (numInArray > max) max = numInArray;
        }
        System.out.println("Максимальное число: " + max);

        // Задача 15: Сумма элементов массива
        sum = 0;
        for (int numInArray : array) {
            sum += numInArray;
        }
        System.out.println("Сумма элементов: " + sum);

        // Задача 16: Количество положительных и отрицательных чисел
        int positive = 0, negative = 0;
        for (int numInArray : array) {
            if (numInArray > 0) positive++;
            else if (numInArray < 0) negative++;
        }
        System.out.println("Положительных: " + positive + ", Отрицательных: " + negative);

        // Задача 17: Простые числа в диапазоне
        System.out.print("Введите A и B (Задача 17): ");
        A = scanner.nextInt();
        B = scanner.nextInt();
        System.out.print("Простые числа: ");
        for (int i = Math.min(A, B); i <= Math.max(A, B); i++) {
            isPrime = i > 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.print(i + " ");
        }
        System.out.println();

        // Задача 18: Гласные и согласные
        System.out.print("Введите строку (Задача 18): ");
        input = scanner.nextLine().toLowerCase();
        int vowels = 0, consonants = 0;
        for (char ch : input.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) vowels++;
            else if (Character.isLetter(ch)) consonants++;
        }
        System.out.println("Гласные: " + vowels + ", Согласные: " + consonants);

        // Задача 19: Перестановка слов в строке
        System.out.print("Введите строку (Задача 19): ");
        input = scanner.nextLine();
        String[] words = input.split(" ");
        System.out.print("Обратный порядок слов: ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println();

        // Задача 20: Число Армстронга
        System.out.print("Введите число (Задача 20): ");
        num = scanner.nextInt();
        int original = num, armstrongSum = 0, digits = String.valueOf(num).length();
        while (num != 0) {
            int digit = num % 10;
            armstrongSum += Math.pow(digit, digits);
            num /= 10;
        }
        System.out.println(original == armstrongSum ? "Число Армстронга" : "Не число Армстронга");
    }
}
