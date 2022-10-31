package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    void numberAddTest() {
        Number a = Number.validator("1");
        Number b = Number.validator("2");
        Number result = a.add(b);
        assertThat(result).isEqualTo(Number.validator("3"));
    }
}
