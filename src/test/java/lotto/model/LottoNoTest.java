package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test
    @DisplayName("로또 번호 객체 정상 생성 확인")
    public void validLottoNo() {
        assertThat(new LottoNo(7).value()).isEqualTo(7);
    }
}
