package lotto.utils;

import java.util.Objects;

public class Validations {
    public static void requireNotNull(final Object object, final String errorMessage) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
