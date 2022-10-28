package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PositiveOperandBagTest {

    @DisplayName("PositiveOperandBag 생성 성공")
    @Test
    void create() {
        //given:
        List<String> input = Arrays.asList("1", "2", "3");
        //when, then:
        assertThatNoException().isThrownBy(() -> new PositiveOperandBag(input));
    }

    @DisplayName("PositiveOperandBag sum() 메서드 테스트")
    @Test
    void sum() {
        //given:
        List<String> input = Arrays.asList("1", "2", "3");
        //when:
        PositiveOperandBag positiveOperandBag = new PositiveOperandBag(input);
        //then:
        assertThat(positiveOperandBag.sum()).isEqualTo(6);
    }
}
