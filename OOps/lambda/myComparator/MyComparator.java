import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface MyComparator<T> {
    int compare(T t1, T t2);

    static <T, U extends Comparable<? super U>> MyComparator<T> comparing(
        Function<T, U> keyExtractor
    ) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            U s1 = keyExtractor.apply(p1);
            U s2 = keyExtractor.apply(p2);

            // compareTo returns 0 if two strings are same
            return s1.compareTo(s2);
        };
    }

    default <U extends Comparable<? super U>> MyComparator<T> andThen(
        Function<T, U> keyExtractor
    ) {
        Objects.requireNonNull(keyExtractor);
        return (T t1, T t2) -> {
            int result = this.compare(t1, t2);
            if (result == 0) {
                MyComparator<T> other = comparing(keyExtractor);
                return other.compare(t1, t2);
            } else {
                return result;
            }
        };
    }

    default MyComparator<T> reversed() {
        return (T t1, T t2) -> this.compare(t1, t2);
    }
}
