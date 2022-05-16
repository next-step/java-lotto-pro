package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    final Lotto lotto = Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("로또 초기화 테스트")
    @Test
    void lotto() {
        Lotto lotto = Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(this.lotto);
    }

    @DisplayName("로또 갯수가 6개가 아니거나 중복되면 IllegalArgumentException 예외")
    @Test
    void lottoInValid() {
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                        .withMessage("로또 번호 갯수가 올바르지 않습니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5)))
                        .withMessage("로또 번호 갯수가 올바르지 않습니다.")
        );
    }

    @DisplayName("당첨 로또 번호와 비교했을때 랭킹에따른 상금(돈) 비교 테스트")
    @Test
    void lottoLottoRanking() {
        Lotto winningLotto = Lotto.valueOf(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(this.lotto.lottoRanking(winningLotto).money()).isEqualTo(Money.valueOf(1500000));
    }
}
