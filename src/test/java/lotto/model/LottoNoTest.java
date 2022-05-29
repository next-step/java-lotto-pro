package lotto.model;

import calculator.Convertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNoTest {
    @Test
    @DisplayName("로또 번호 객체 정상 생성 확인")
    public void validLottoNo() {
        assertThat(new LottoNo(7).value()).isEqualTo(7);
    }

    @Test
    @DisplayName("로또 번호의 유효성 검증")
    public void notValidLottoNo() {
        assertThatThrownBy(() -> new LottoNo(100)).isInstanceOf(IllegalArgumentException.class);
    }
}
