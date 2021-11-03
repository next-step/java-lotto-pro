package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    public static final int LOTTO_MAX_SIZE = 6;

    @DisplayName("로또번호 생성 테스트")
    @Test
    void createLottoTest() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLotto().size()).isEqualTo(LOTTO_MAX_SIZE);
    }
}