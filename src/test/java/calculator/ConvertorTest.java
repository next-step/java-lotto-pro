package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConvertorTest {

    @Test
    @DisplayName("String 숫자 배열을 int 배열로 변경")
    public void convertStringToInteger() {
        String[] strings = {"1", "2", "3"};
        assertThat(Convertor.convert(strings)).contains(1, 2, 3);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 배열에 있을 경우")
    public void checkNotNumber() {
        String[] target = {"1", "a", "b"};
        assertThatThrownBy(() -> Convertor.convert(target)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 배열에 있을 경우")
    public void checkNegativeNumber() {
        String[] target = {"1", "-3", "-5"};
        assertThatThrownBy(() -> Convertor.convert(target)).isInstanceOf(RuntimeException.class);
    }
}
