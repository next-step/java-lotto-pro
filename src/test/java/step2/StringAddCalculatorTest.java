package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열을 입력받을 때, 빈 문자열인 경우 0을 리턴한다.")
    void input_test(String inputText) {
        int result = stringAddCalculator.sum(inputText);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력 테스트를 해본다.")
    void one_number_test() {
        int result = stringAddCalculator.sum("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void splitAndSum_comma() throws Exception {
        int result = stringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

}