/* this is a trial to mimic the Predicate Interface of JDK and obviously a
  great to know the lalmbda expression implemantation very deeply */
import java.util.*;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);

    default MyPredicate<T> and(MyPredicate<T> other) {
        // to prevent null pointer exception for 'MyPredicate<T> other' we need to catch it at compile time
        // Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }
}
