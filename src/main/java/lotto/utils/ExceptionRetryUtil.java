package lotto.utils;

import lotto.view.ResultView;

import java.util.function.Supplier;

public class ExceptionRetryUtil {
    public static  <T> T retryThrowInput(Supplier<T> supplier) {
        T t = null;
        do {
            try {
                t = supplier.get();
            } catch (IllegalArgumentException illegalArgumentException) {
                ResultView.printMessage(illegalArgumentException.getMessage());
            }
        } while (t == null);

        return t;
    }
}
