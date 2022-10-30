package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCalculatorTest {

    @Test
    @DisplayName("로또 구매 최소비용 이상인지 확인")
    void validateMoney() {
        assertThatThrownBy(() -> {
            LottoCalculator.availableToPurchaseCount(new Money(500));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 가능 갯수 계산")
    void availableToPurchaseCount() {
        assertThat(LottoCalculator.availableToPurchaseCount(new Money(5000))).isEqualTo(5);
    }

    @Test
    @DisplayName("당첨 갯수 확인")
    void winning() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"));
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(LottoNumbers.generate("1,2,3,4,5,6")),
                new Lotto(LottoNumbers.generate("1,2,3,4,5,6"))
        ));
        assertThat(LottoCalculator.winningCount(winningLotto, lottos, Rank.FIRST)).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 금액 확인")
    void winningTotalMoney() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"));
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(LottoNumbers.generate("1,2,3,7,8,9")),
                new Lotto(LottoNumbers.generate("1,2,3,7,8,9")),
                new Lotto(LottoNumbers.generate("1,2,10,11,12,13"))
        ));
        assertThat(LottoCalculator.winningTotalMoney(winningLotto, lottos)).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("수익률 계산")
    void rateOfReturn() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"));
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(LottoNumbers.generate("1,2,3,7,8,9")),
                new Lotto(LottoNumbers.generate("1,2,10,11,12,13")),
                new Lotto(LottoNumbers.generate("1,2,10,11,12,13")),
                new Lotto(LottoNumbers.generate("1,2,10,11,12,13")),
                new Lotto(LottoNumbers.generate("1,2,10,11,12,13"))
        ));
        assertThat(LottoCalculator.rateOfReturn(winningLotto, lottos)).isEqualTo(1.0);

    }

}
