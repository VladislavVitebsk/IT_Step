package HomeWork_20240328_Pair;

import java.util.Objects;
import java.util.function.BiConsumer;

public class Pair<T, U> {

    private final T first;
    private final U second;

    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }

    public static <T, U> Pair<T, U> empty() {
        return new Pair<>(null, null);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void ifPresent(BiConsumer<T, U> consumer) {
        if (first != null && second != null) {
            consumer.accept(first, second);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
    public static void main(String[] args) {
        Pair<String, Integer> pair = Pair.of("Hello", 123);

        pair.ifPresent((s, i) -> System.out.println(s + " " + i));

        Pair<String, Integer> emptyPair = Pair.empty();
    }
}
