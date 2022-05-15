package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {
    @Test
    @DisplayName("로또 수익률을 확인한다.")
    void 테스트_로또_수익률_확인() {
        double result = 0.5;
        Assertions.assertThat(new LottoWinning(result)).isEqualTo(new LottoWinning(0.5));
    }
}
