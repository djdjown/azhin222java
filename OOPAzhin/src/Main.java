import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Задача 1: Класс "Человек"
    static class Person {
        private String name;
        private int age;
        private String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
        }

        public void increaseAge() {
            age++;
        }

        public void changeName(String newName) {
            name = newName;
        }
    }

    // Задача 2: Наследование: Классы "Работник" и "Менеджер"
    static class Worker extends Person {
        private double salary;

        public Worker(String name, int age, String gender, double salary) {
            super(name, age, gender);
            this.salary = salary;
        }

        public void displaySalary() {
            System.out.println("Salary: " + salary);
        }
    }

    static class Manager extends Worker {
        private String[] subordinates;

        public Manager(String name, int age, String gender, double salary, String[] subordinates) {
            super(name, age, gender, salary);
            this.subordinates = subordinates;
        }

        public void displaySubordinates() {
            System.out.println("Subordinates: " + String.join(", ", subordinates));
        }
    }

    // Задача 3: Полиморфизм: Животные
    interface Animal {
        void makeSound();
    }

    static class Dog implements Animal {
        public void makeSound() {
            System.out.println("Bark");
        }
    }

    static class Cat implements Animal {
        public void makeSound() {
            System.out.println("Meow");
        }
    }

    static class Cow implements Animal {
        public void makeSound() {
            System.out.println("Moo");
        }
    }

    // Задача 4: Абстрактный класс "Транспорт"
    abstract static class Transport {
        public abstract void move();
    }

    static class Car extends Transport {
        public void move() {
            System.out.println("Car is moving");
        }
    }

    static class Bike extends Transport {
        public void move() {
            System.out.println("Bike is moving");
        }
    }

    // Задача 5: Класс "Книга" и "Библиотека"
    static class Book {
        private String title;
        private String author;
        private int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        public String getTitle() {
            return title;
        }
    }

    static class Library {
        private List<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public List<Book> findByAuthor(String author) {
            return books.stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
        }

        public List<Book> findByYear(int year) {
            return books.stream().filter(b -> b.getYear() == year).collect(Collectors.toList());
        }
    }

    // Задача 6: Инкапсуляция: Банк
    static class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    // Задача 7: Счетчик объектов
    static class Counter {
        private static int count = 0;

        public Counter() {
            count++;
        }

        public static int getCount() {
            return count;
        }
    }

    // Задача 8: Площадь фигур
    abstract static class Shape {
        public abstract double getArea();
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    static class RectangleShape extends Shape { 
        private double length;
        private double width;

        public RectangleShape(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getArea() {
            return length * width;
        }
    }

    // Задача 9: Наследование: Животные и их движения
    static class AnimalMove {
        public void move() {
            System.out.println("Animal moves");
        }
    }

    static class Fish extends AnimalMove {
        @Override
        public void move() {
            System.out.println("Fish swims");
        }
    }

    static class Bird extends AnimalMove {
        @Override
        public void move() {
            System.out.println("Bird flies");
        }
    }

    static class DogMove extends AnimalMove {
        @Override
        public void move() {
            System.out.println("Dog runs");
        }
    }

    // Задача 10: Работа с коллекциями: Университет
    static class Student {
        private String name;
        private String group;
        private double grade;

        public Student(String name, String group, double grade) {
            this.name = name;
            this.group = group;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }

        public String getName() {
            return name;
        }
    }

    static class University {
        private List<Student> students = new ArrayList<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        public List<Student> filterByGrade(double grade) {
            return students.stream().filter(s -> s.getGrade() >= grade).collect(Collectors.toList());
        }

        public List<Student> sortByName() {
            return students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        }
    }

    // Задача 11: Класс "Магазин"
    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Store {
        private List<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public Product findProductByName(String name) {
            return products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        }
    }

    // Задача 12: Интерфейс "Платежная система"
    interface PaymentSystem {
        void pay();
        void refund();
    }

    static class CreditCard implements PaymentSystem {
        public void pay() {
            System.out.println("Paying with Credit Card");
        }

        public void refund() {
            System.out.println("Refunding Credit Card");
        }
    }

    static class PayPal implements PaymentSystem {
        public void pay() {
            System.out.println("Paying with PayPal");
        }

        public void refund() {
            System.out.println("Refunding PayPal");
        }
    }

    // Задача 13: Генерация уникальных идентификаторов
    static class UniqueID {
        private static int counter = 0;

        public static int generateID() {
            return ++counter;
        }
    }

    // Задача 14: Класс "Точка" и "Прямоугольник"
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class RectangleCoordinates { 
        private Point topLeft;
        private Point bottomRight;

        public RectangleCoordinates(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public int getArea() {
            int width = bottomRight.getX() - topLeft.getX();
            int height = bottomRight.getY() - topLeft.getY();
            return width * height;
        }
    }

    // Задача 15: Комплексные числа
    static class ComplexNumber {
        private double real;
        private double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public ComplexNumber add(ComplexNumber other) {
            return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
        }

        public ComplexNumber subtract(ComplexNumber other) {
            return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
        }

        public ComplexNumber multiply(ComplexNumber other) {
            return new ComplexNumber(
                    this.real * other.real - this.imaginary * other.imaginary,
                    this.real * other.imaginary + this.imaginary * other.real
            );
        }

        public ComplexNumber divide(ComplexNumber other) {
            double denominator = other.real * other.real + other.imaginary * other.imaginary;
            return new ComplexNumber(
                    (this.real * other.real + this.imaginary * other.imaginary) / denominator,
                    (this.imaginary * other.real - this.real * other.imaginary) / denominator
            );
        }
    }

    // Задача 16: Перегрузка операторов: Матрица
    static class Matrix {
        private int[][] data;

        public Matrix(int rows, int cols) {
            data = new int[rows][cols];
        }

        public void setValue(int row, int col, int value) {
            data[row][col] = value;
        }

        public Matrix add(Matrix other) {
            int rows = data.length;
            int cols = data[0].length;
            Matrix result = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.data[i][j] = this.data[i][j] + other.data[i][j];
                }
            }
            return result;
        }

        public Matrix multiply(Matrix other) {
            int rows = data.length;
            int cols = other.data[0].length;
            Matrix result = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    for (int k = 0; k < data[0].length; k++) {
                        result.data[i][j] += data[i][k] * other.data[k][j];
                    }
                }
            }
            return result;
        }
    }

    // Задача 17: Создание игры с использованием ООП
    static class Player {
        private String name;
        private int health;

        public Player(String name, int health) {
            this.name = name;
            this.health = health;
        }

        public void attack(Enemy enemy) {
            System.out.println(name + " attacks " + enemy.getName());
            enemy.takeDamage(10);
        }

        public void takeDamage(int damage) {
            health -= damage;
            System.out.println(name + " takes " + damage + " damage, remaining health: " + health);
        }
    }

    static class Enemy {
        private String name;
        private int health;

        public Enemy(String name, int health) {
            this.name = name;
            this.health = health;
        }

        public String getName() {
            return name;
        }

        public void takeDamage(int damage) {
            health -= damage;
            System.out.println(name + " takes " + damage + " damage, remaining health: " + health);
        }
    }

    static class Weapon {
        private String name;
        private int damage;

        public Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public void use(Player player, Enemy enemy) {
            System.out.println(player + " uses " + name);
            enemy.takeDamage(damage);
        }
    }

    // Задача 18: Автоматизированная система заказов
    static class Order {
        private List<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public double getTotalPrice() {
            return products.stream().mapToDouble(p -> p.getPrice()).sum();
        }
    }

    static class Customer {
        private String name;

        public Customer(String name) {
            this.name = name;
        }
    }

    // Задача 19: Наследование: Электроника
    static class Device {
        private String brand;

        public Device(String brand) {
            this.brand = brand;
        }

        public void turnOn() {
            System.out.println(brand + " is turned on.");
        }

        public void turnOff() {
            System.out.println(brand + " is turned off.");
        }
    }

    static class Smartphone extends Device {
        public Smartphone(String brand) {
            super(brand);
        }

        public void takePhoto() {
            System.out.println("Taking a photo with smartphone");
        }
    }

    static class Laptop extends Device {
        public Laptop(String brand) {
            super(brand);
        }

        public void code() {
            System.out.println("Coding on laptop");
        }
    }

    // Задача 20: Игра "Крестики-нолики"
    static class Game {
        private char[][] board = new char[3][3];
        private char currentPlayer = 'X';

        public Game() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '.';
                }
            }
        }

        public boolean makeMove(int row, int col) {
            if (board[row][col] == '.') {
                board[row][col] = currentPlayer;
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                return true;
            }
            return false;
        }

        public void printBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Пример вызова задач:
        Person person = new Person("John", 30, "Male");
        person.displayInfo();
        person.increaseAge();
        person.changeName("Mike");

        Worker worker = new Worker("Jane", 28, "Female", 50000);
        worker.displaySalary();

        Manager manager = new Manager("Alice", 40, "Female", 70000, new String[] {"Tom", "Jerry"});
        manager.displaySubordinates();

        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) {
            animal.makeSound();
        }

        Transport car = new Car();
        car.move();

        Transport bike = new Bike();
        bike.move();

        Book book = new Book("1984", "George Orwell", 1949);
        Library library = new Library();
        library.addBook(book);

        BankAccount account = new BankAccount("12345", 1000);
        account.deposit(500);
        System.out.println("Balance: " + account.getBalance());

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        System.out.println("Object count: " + Counter.getCount());

        Shape circle = new Circle(5);
        System.out.println("Circle area: " + circle.getArea());

        Shape rectangle = new RectangleShape(4, 6); 
        System.out.println("Rectangle area: " + rectangle.getArea());

        Student student1 = new Student("John", "A1", 4.0);
        University university = new University();
        university.addStudent(student1);

        Product product = new Product("Laptop", 1000, 5);
        Store store = new Store();
        store.addProduct(product);

        PaymentSystem paypal = new PayPal();
        paypal.pay();

        UniqueID id = new UniqueID();
        System.out.println("Unique ID: " + UniqueID.generateID());

        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        RectangleCoordinates rectangle2 = new RectangleCoordinates(p1, p2); 
        System.out.println("Rectangle area from points: " + rectangle2.getArea());
    }
}
