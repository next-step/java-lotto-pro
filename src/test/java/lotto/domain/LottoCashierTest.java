package lotto.domain;

import lotto.auto.AutoLottoPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCashierTest {

    private LottoCashier lottoCashier;

    @BeforeEach
    void setUp() {
        lottoCashier = new LottoCashier(new AutoLottoPrinter(new CollectionsShuffler()));
    }

    @DisplayName("1000원으로 나누어지지 않는 금액을 받으면 오류를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {100, 1001, 0, 12340})
    void testGivenWrongCashThrowException(int cash) {
        assertThatThrownBy(() -> lottoCashier.buy(Money.of(cash))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로 구매하실 수 있습니다");
    }

    @DisplayName("금액을 입력 받으면 살 수 있는 로또 갯수를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 33000, 44000, 576000})
    void testReturnLottoCount(int cash) {
        assertThat(lottoCashier.buy(Money.of(cash)).size()).isEqualTo(cash / 1000);
    }

    @DisplayName("원하는 수량만큼 살 수 있는 금액인지 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1500:2:false", "1000:1:true", "1000:0:true"}, delimiter = ':')
    void testIsPossibleToBuy(int cash, int count, boolean result) {
        assertThat(lottoCashier.isPossibleToBuy(Money.of(cash), count)).isEqualTo(result);
    }
}
