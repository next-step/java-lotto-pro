package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoBonusTest {

    private Lotto lotto;
    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    private void setUp() {
        this.lottoWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        this.lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    }

    @Test
    @DisplayName("구입한 로또가 보너스볼이 포함된 로또일경우에 참을 리턴한다.")
    void whenIsBonusVersion_thenTrue() {
        assertThat(this.lotto.isMatchedBonus(lottoWinningNumber)).isTrue();
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 같을 경우 에러를 던진다.")
    void whenWinningNumberEqualsBonusNumber_thenThrow() {
        assertThrows(RuntimeException.class, () -> new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6), 6));
    }
}
