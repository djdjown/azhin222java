import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.util.concurrent.*;


// Задание 1: Работа с потоками ввода-вывода
class IOFileProcessor {
    public static void processFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка обработки файла: " + e.getMessage());
        }
    }
}

// Задание 2: Реализация паттерна Декоратор
interface TextProcessor {
    String process(String text);
}
class SimpleTextProcessor implements TextProcessor {
    public String process(String text) { return text; }
}
abstract class TextDecorator implements TextProcessor {
    protected TextProcessor processor;
    public TextDecorator(TextProcessor processor) { this.processor = processor; }
}
class UpperCaseDecorator extends TextDecorator {
    public UpperCaseDecorator(TextProcessor processor) { super(processor); }
    public String process(String text) { return processor.process(text).toUpperCase(); }
}
class TrimDecorator extends TextDecorator {
    public TrimDecorator(TextProcessor processor) { super(processor); }
    public String process(String text) { return processor.process(text).trim(); }
}
class ReplaceDecorator extends TextDecorator {
    public ReplaceDecorator(TextProcessor processor) { super(processor); }
    public String process(String text) { return processor.process(text).replace(" ", "_"); }
}

// Задание 3: Сравнение IO и NIO
class PerformanceTest {
    public static void measureIO(String inputFile, String outputFile) {
        long start = System.nanoTime();
        IOFileProcessor.processFile(inputFile, outputFile);
        long end = System.nanoTime();
        System.out.println("IO Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static void measureNIO(String inputFile, String outputFile) {
        long start = System.nanoTime();
        try (FileChannel srcChannel = new FileInputStream(inputFile).getChannel();
             FileChannel destChannel = new FileOutputStream(outputFile).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (srcChannel.read(buffer) > 0) {
                buffer.flip();
                destChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            System.err.println("Ошибка NIO: " + e.getMessage());
        }
        long end = System.nanoTime();
        System.out.println("NIO Time: " + (end - start) / 1_000_000 + " ms");
    }
}

// Задание 4: Копирование файла через NIO
class FileCopier {
    public static void copyFile(String source, String dest) {
        try (FileChannel srcChannel = new FileInputStream(source).getChannel();
             FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
            srcChannel.transferTo(0, srcChannel.size(), destChannel);
        } catch (IOException e) {
            System.err.println("Ошибка копирования: " + e.getMessage());
        }
    }
}

// Задание 5: Асинхронное чтение файла с использованием NIO.2
class AsyncFileReader {
    public static void readFileAsync(String filePath) {
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get(filePath), StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer, 0, buffer, new CompletionHandler<>() {
                public void completed(Integer result, ByteBuffer attachment) {
                    attachment.flip();
                    System.out.println(new String(attachment.array(), 0, result));
                    try { channel.close(); } catch (IOException ignored) {}
                }
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println("Ошибка чтения: " + exc.getMessage());
                }
            });
        } catch (IOException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
        }
    }
}

// Точка входа
public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String copyFile = "copy.txt";

        // Задание 1
        IOFileProcessor.processFile(inputFile, outputFile);

        // Задание 2
        TextProcessor processor = new ReplaceDecorator(new UpperCaseDecorator(new TrimDecorator(new SimpleTextProcessor())));
        System.out.println(processor.process(" Hello world "));

        // Задание 3
        PerformanceTest.measureIO(inputFile, outputFile);
        PerformanceTest.measureNIO(inputFile, outputFile);

        // Задание 4
        FileCopier.copyFile(inputFile, copyFile);

        // Задание 5
        AsyncFileReader.readFileAsync(inputFile);
    }
}
