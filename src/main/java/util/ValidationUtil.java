package util;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ValidationUtil {
    public static <T> void validatePredicate(Predicate<T> predicate, T target, String exceptionMessage) {
        if (predicate.test(target)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static <T, U> void validateBiPredicate(BiPredicate<T, U> biPredicate, T targetFirst, U targetSecond,
                                                  String exceptionMessage) {
        if (biPredicate.test(targetFirst, targetSecond)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
