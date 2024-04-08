package HomeWork_20240311_20240408;

import java.util.ArrayList;
import java.util.List;

//Шаг 4: Использование декоратора для измерения времени работы алгоритмов.
public class SequenceGenerator {
    public static void main(String[] args) {
        NumberSequenceGenerator fibonacciGenerator = new FibonacciSequenceGenerator();
        NumberSequenceGenerator primeNumberGenerator = new PrimeNumberSequenceGenerator();
        NumberSequenceGenerator factorialGenerator = new FactorialSequenceGenerator();

        NumberSequenceGenerator timedFibonacciGenerator = new TimeDecorator(fibonacciGenerator);
        NumberSequenceGenerator timedPrimeNumberGenerator = new TimeDecorator(primeNumberGenerator);
        NumberSequenceGenerator timedFactorialGenerator = new TimeDecorator(factorialGenerator);

        List<Integer> fibonacciSequence = timedFibonacciGenerator.generateSequence(10);
        List<Integer> primeNumberSequence = timedPrimeNumberGenerator.generateSequence(10);
        List<Integer> factorialSequence = timedFactorialGenerator.generateSequence(10);
    }
}
//Шаг 1: Создание интерфейса для генератора последовательностей чисел.
public interface NumberSequenceGenerator {
    List<Integer> generateSequence(int n);
}
//Шаг 2: Создание классов для конкретных последовательностей чисел - Фибоначчи, простых чисел, факториалов.
public class FibonacciSequenceGenerator implements NumberSequenceGenerator {
    @Override
    public List<Integer> generateSequence(int n) {
        List<Integer> sequence = new ArrayList<>();// генерация последовательности чисел Фибоначчи
        return sequence;
    }
}
public class PrimeNumberSequenceGenerator implements NumberSequenceGenerator {
    @Override
    public List<Integer> generateSequence(int n) {
        List<Integer> sequence = new ArrayList<>();// генерация последовательности простых чисел
        return sequence;
    }
}
public class FactorialSequenceGenerator implements NumberSequenceGenerator {
    @Override
    public List<Integer> generateSequence(int n) {
        List<Integer> sequence = new ArrayList<>();// генерация последовательности факториалов чисел
        return sequence;
    }
}
//Шаг 3: Создание класса-декоратора для измерения времени работы алгоритма.
public class TimeDecorator implements NumberSequenceGenerator {
    private NumberSequenceGenerator generator;

    public TimeDecorator(NumberSequenceGenerator generator) {
        this.generator = generator;
    }

    @Override
    public List<Integer> generateSequence(int n) {
        long startTime = System.nanoTime();
        List<Integer> sequence = generator.generateSequence(n);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        return sequence;
    }
}