package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class IntegerArrayConverterTest {


    @DisplayName("IntegerArrayConverter 의 convert 함수가 # 으로 구분된 값을 의도대로 잘 나누어 주는지 확인")
    @Test
    void IntegerArrayConverterTest01() {
        IntegerArrayConverter converter = new IntegerArrayConverter();
        Object convert = converter.convert("1#2", int[].class);

        assertThat(convert)
                .isInstanceOf(String[].class);
        int[] ints = (int[]) convert;

        assertThat(ints)
                .hasSize(2)
                .containsExactly(1, 2);
    }

    @DisplayName("IntegerArrayConverter 의 convert 함수가 int[]가 아닌 값으로 처리시 에러 발생 확인")
    @Test
    void IntegerArrayConverterTest02() {
        IntegerArrayConverter converter = new IntegerArrayConverter();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Object convert = converter.convert("1#2", String[].class);
        });
    }
}
