import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Singleton для базы данных
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Создано подключение к базе данных");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

// Singleton для логирования
class Logger {
    private static Logger instance;
    private List<String> logs = new ArrayList<>();

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logs.add(message);
    }

    public void printLogs() {
        logs.forEach(System.out::println);
    }
}

// Enum для статусов заказа
enum OrderStatus {
    NEW, IN_PROGRESS, DELIVERED, CANCELLED;
}

class Order {
    private String orderId;
    private OrderStatus status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.NEW;
    }

    public void changeStatus(OrderStatus newStatus) {
        if (this.status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
            System.out.println("Нельзя отменить доставленный заказ");
        } else {
            this.status = newStatus;
        }
    }

    public OrderStatus getStatus() {
        return status;
    }
}

// Enum для сезонов
enum Season {
    WINTER, SPRING, SUMMER, AUTUMN;
}

class SeasonHelper {
    public static String getSeasonName(Season season) {
        switch (season) {
            case WINTER: return "Зима";
            case SPRING: return "Весна";
            case SUMMER: return "Лето";
            case AUTUMN: return "Осень";
            default: return "Неизвестно";
        }
    }
}

public class Main {
    public static void main(String[] args) {

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println(db1 == db2);


        Logger logger = Logger.getInstance();
        logger.log("Первый лог");
        logger.log("Второй лог");
        logger.printLogs();


        Order order = new Order("123");
        System.out.println("Статус заказа: " + order.getStatus());
        order.changeStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Статус заказа: " + order.getStatus());
        order.changeStatus(OrderStatus.DELIVERED);
        order.changeStatus(OrderStatus.CANCELLED);


        System.out.println("Сезон Лето: " + SeasonHelper.getSeasonName(Season.SUMMER));
    }
}
