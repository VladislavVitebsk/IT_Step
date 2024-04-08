package HomeWork_20240311_20240408_v2;
/*Разработать приложение java, генерирующее несколько последовательностей чисел
(по заранее заданному алгоритму, например, последовательность чисел Фибоначчи,
последовательность простых чисел, последовательность факториалов целых неотрицательных чисел).
Генерирование типа последовательности и количество генерируемых элементов должно определяться пользователем.
Для каждой последовательности после генерации указать время работы соответствующего алгоритма.
Определение этого времени реализовать, используя шаблон проектирования «Decorator».
Для шаблона проектирования «Decorator» реализовать сначала базовую функциональность приложения,
и только после этого, не меняя классы, реализующие эту функциональность, добавить класс (классы),
реализующие с помощью декоратора расширенную функциональность. Аналогично для шаблона проектирования «Composite»
сначала необходимо реализовать обработку базовых объектов, и только после этого с помощью компоновщика
объединять их в составные объекты (в наборы объектов).
 */
import java.util.Scanner;
// Интерфейс генератора последовательностей
interface SequenceGenerator {
    int[] generateSequence(int n);
}
// Класс генератора последовательности чисел Фибоначчи
class FibonacciGenerator implements SequenceGenerator {
    @Override
    public int[] generateSequence(int n) {
        int[] sequence = new int[n];
        sequence[0] = 0;
        if (n > 1) {
            sequence[1] = 1;
            for (int i = 2; i < n; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2];
            }
        }
        return sequence;
    }
}
// Класс генератора последовательности простых чисел
class PrimeNumberGenerator implements SequenceGenerator {
    @Override
    public int[] generateSequence(int n) {
        int[] sequence = new int[n];
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                sequence[count] = number;
                count++;
            }
            number++;
        }
        return sequence;
    }
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// Декоратор для измерения времени работы генератора последовательности
class TimingDecorator implements SequenceGenerator {
    private SequenceGenerator generator;
    public TimingDecorator(SequenceGenerator generator) {
        this.generator = generator;
    }
    @Override
    public int[] generateSequence(int n) {
        long startTime = System.currentTimeMillis();
        int[] sequence = generator.generateSequence(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (endTime - startTime) + " миллисекунды");
        return sequence;
    }
}
public class SequenceGenerator_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип последовательности:\n1. Последовательность Фибоначчи \n2. Последовательность простых чисел");
        int choice = scanner.nextInt();
        System.out.println("Введите количество элементов в последовательности:");
        int n = scanner.nextInt();
        SequenceGenerator generator;
        if (choice == 1) {
            generator = new TimingDecorator(new FibonacciGenerator());
        } else {
            generator = new TimingDecorator(new PrimeNumberGenerator());
        }
        int[] sequence = generator.generateSequence(n);
        System.out.println("Сгенерированная последовательность:");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
    }
}
