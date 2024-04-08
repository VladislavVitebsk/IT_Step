package HomeWork_20240311_20240408;
import java.util.Scanner;

interface Sequence {
    void generate(int n);
}

class FibonacciSequence implements Sequence {
    @Override
    public void generate(int n) {
        long startTime = System.nanoTime();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime taken to generate Fibonacci Sequence: " + (endTime - startTime) + " nanoseconds");
    }
}

class PrimeSequence implements Sequence {
    @Override
    public void generate(int n) {
        long startTime = System.nanoTime();
        int count = 0;
        for (int i = 2; count < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
                count++;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime taken to generate Prime Sequence: " + (endTime - startTime) + " nanoseconds");
    }
}

class FactorialSequence implements Sequence {
    @Override
    public void generate(int n) {
        long startTime = System.nanoTime();
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            System.out.print(fact + " ");
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime taken to generate Factorial Sequence: " + (endTime - startTime) + " nanoseconds");
    }
}

class SequenceGeneratorDecorator implements Sequence {
    private Sequence sequence;

    public SequenceGeneratorDecorator(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void generate(int n) {
        sequence.generate(n);
    }
}

public class SequenceGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of sequence to generate:");
        System.out.println("1 - Fibonacci Sequence");
        System.out.println("2 - Prime Sequence");
        System.out.println("3 - Factorial Sequence");
        int choice = scanner.nextInt();

        System.out.println("Enter the number of elements to generate:");
        int n = scanner.nextInt();

        Sequence sequence = null;
        switch (choice) {
            case 1:
                sequence = new SequenceGeneratorDecorator(new FibonacciSequence());
                break;
            case 2:
                sequence = new SequenceGeneratorDecorator(new PrimeSequence());
                break;
            case 3:
                sequence = new SequenceGeneratorDecorator(new FactorialSequence());
                break;
            default:
                System.out.println("Invalid choice");
        }

        if (sequence != null) {
            sequence.generate(n);
        }
    }
}
