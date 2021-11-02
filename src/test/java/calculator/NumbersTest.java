package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("숫자들의 합 구하기")
    @Test
    void sum() {
        Numbers numbers = new Numbers(new String[]{"1", "2", "3"});
        assertThat(numbers.sum()).isEqualTo(6);
    }

}