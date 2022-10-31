package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCalculatorTest {

    @Test
    @DisplayName("500원은 로또 구매 최소비용이 안된다.")
    void validateMoney() {
        assertThatThrownBy(() -> {
            LottoCalculator.availableToPurchaseCount(new Money(500));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5000원으로 구매 가능한 로또 개수는 5개이다")
    void availableToPurchaseCount() {
        assertThat(LottoCalculator.availableToPurchaseCount(new Money(5000))).isEqualTo(5);
    }

    @Test
    @DisplayName("1등 당첨 개수는 2개이다")
    void winning() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of("7"));
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(LottoNumbers.generate("1,2,3,4,5,6")),
                Lotto.of(LottoNumbers.generate("1,2,3,4,5,6"))
        ));
        assertThat(LottoCalculator.winningCount(winningLotto, lottos, Rank.FIRST)).isEqualTo(2);
    }

    @Test
    @DisplayName("번호 3개를 맞춘 로또 2장 당첨 금액은 10000원이다")
    void winningTotalMoney() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of("7"));
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(LottoNumbers.generate("1,2,3,7,8,9")),
                Lotto.of(LottoNumbers.generate("1,2,3,7,8,9")),
                Lotto.of(LottoNumbers.generate("1,2,10,11,12,13"))
        ));
        assertThat(LottoCalculator.winningTotalMoney(winningLotto, lottos)).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("1000원짜리 로또 5장으로 5000원에 당첨 됬다면 당첨수익률은 1.0이다")
    void rateOfReturn() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of("7"));
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(LottoNumbers.generate("1,2,3,7,8,9")),
                Lotto.of(LottoNumbers.generate("1,2,10,11,12,13")),
                Lotto.of(LottoNumbers.generate("1,2,10,11,12,13")),
                Lotto.of(LottoNumbers.generate("1,2,10,11,12,13")),
                Lotto.of(LottoNumbers.generate("1,2,10,11,12,13"))
        ));
        assertThat(LottoCalculator.rateOfReturn(winningLotto, lottos)).isEqualTo(1.0);

    }

}
