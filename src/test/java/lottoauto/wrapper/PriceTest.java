package lottoauto.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void 입력값_계산() {
        assertThat(new Price("14000").getTryTimes()).isEqualTo(14);
    }

    @Test
    void 입력값_오류() {
        assertThatThrownBy(() -> new Price("poibi")).isInstanceOf(NumberFormatException.class).hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    void 입력값_음수() {
        assertThatThrownBy(() -> new Price("-14")).isInstanceOf(NumberFormatException.class).hasMessage("양수만 입력 가능합니다.");
    }
}
