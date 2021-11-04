package lotto.domain;

import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = 15000)
    @DisplayName("금액에 따라 로또 구입개수 확인")
    public void purchaseLotto(int purchaseAmount) {
        Lotto lotto = new Lotto(purchaseAmount);

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(15);
    }

    @ParameterizedTest
    @ValueSource(ints = 15500)
    @DisplayName("구입 금액 검증(1000원으로 나눴을경우 나머지가 0이 아닐경우)")
    public void validateRemainderAmount(int purchaseAmount) {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @DisplayName("구입 금액 검증(0원을 입력했을 경우)")
    public void validateZeroAmount(int purchaseAmount) {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(purchaseAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}