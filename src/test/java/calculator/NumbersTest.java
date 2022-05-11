package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("합을 반환한다")
    @Test
    void sum() {
        // given
        String[] tokens = {"1", "2", "3"};
        Numbers numbers = new Numbers(tokens);
        // when
        int result = numbers.sum();
        // then
        assertThat(result).isEqualTo(6);
    }

}