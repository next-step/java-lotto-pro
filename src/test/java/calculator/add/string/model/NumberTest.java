package calculator.add.string.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @DisplayName("양수가 아닌 문자열이 입력되었을 떄 예외를 반환하는지 확인.")
    @ValueSource(strings = {"-1,0,test,a"})
    void 양수가_아닌_문자열이_입력되었을_때(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

}
