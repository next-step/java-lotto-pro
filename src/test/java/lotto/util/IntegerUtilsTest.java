package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerUtilsTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Test
    public void createIntegersBetween_갯수() {
        List<Integer> integers = IntegerUtils.createIntegersBetween(MIN_NUMBER, MAX_NUMBER);

        assertThat(integers.size()).isEqualTo(MAX_NUMBER - MIN_NUMBER + 1);
    }

    @Test
    public void createIntegersBetween_최대값() {
        List<Integer> integers = IntegerUtils.createIntegersBetween(MIN_NUMBER, MAX_NUMBER);

        Integer maxNumber = Collections.max(integers);

        assertThat(maxNumber).isEqualTo(Integer.valueOf(MAX_NUMBER));
    }

    @Test
    public void createIntegersBetween_최소값() {
        List<Integer> integers = IntegerUtils.createIntegersBetween(MIN_NUMBER, MAX_NUMBER);

        Integer minNumber = Collections.min(integers);

        assertThat(minNumber).isEqualTo(Integer.valueOf(MIN_NUMBER));
    }
}