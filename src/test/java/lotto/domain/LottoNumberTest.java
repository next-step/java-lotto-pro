package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    @DisplayName("객체 비교 테스트")
    public void constructorTest() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }
}