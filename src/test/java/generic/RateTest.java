package generic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateTest {

    @Test
    @DisplayName("비율 객체 생성 확인")
    void valueOf() {
        // when & then
        assertThat(Rate.valueOf(1.0)).isEqualTo(Rate.valueOf(1.0));
    }

    @Test
    @DisplayName("비율 객체 값을 integer 값으로 반환")
    void getIntValue() {
        // when & then
        assertThat(Rate.valueOf(1.0).getIntValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("비율 객체 값만 문자열로 반환")
    void toStringValue() {
        // when & then
        assertThat(Rate.valueOf(1.0).toStringValue()).isEqualTo("1.0");
    }
}