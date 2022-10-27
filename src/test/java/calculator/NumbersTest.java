package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new Numbers();
        numbers.add(Number.valueOf("1"));
        numbers.add(Number.valueOf("2"));
        numbers.add(Number.valueOf("3"));
        numbers.add(Number.valueOf("4"));
    }

    @Test
    void 숫자를_하나씩_추가한다() {
        List<Number> expectedNumberList = Arrays.asList(
            Number.valueOf("1"),
            Number.valueOf("2"),
            Number.valueOf("3"),
            Number.valueOf("4")
        );
        assertThat(numbers).isEqualTo(new Numbers(expectedNumberList));
    }

    @Test
    void 숫자의_합계를_구한다() {
        assertThat(numbers.sum()).isEqualTo(Number.valueOf("10"));
    }
}
