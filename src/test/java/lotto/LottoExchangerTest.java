package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.ManualLottoes;
import lotto.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoExchanger 클래스 테스트")
class LottoExchangerTest {

    private final LottoGenerator fixedLottoGenerator = () -> Lotto.of(1, 2, 3, 4, 5, 6);
    private final LottoExchanger lottoExchanger = new LottoExchanger(fixedLottoGenerator);

    @DisplayName("LottoExchanger 생성")
    @Test
    void create() {
        final LottoExchanger lottoExchanger = new LottoExchanger(fixedLottoGenerator);
        assertThat(lottoExchanger).isNotNull();
    }

    @DisplayName("Money가 부족하여 Lotto를 구매할 수 없어 `NotEnoughMoneyException`가 발생")
    @Test
    void failureExchange() {
        assertThatThrownBy(() -> {
            lottoExchanger.exchange(Money.of(999), ManualLottoes.empty());
        })
        .isInstanceOf(NotEnoughMoneyException.class)
        .hasMessageContaining("Money가 충분하지 않습니다.");
    }

    @DisplayName("Money가 부족하여 ManualLottoes를 구매할 수 없어 예외 발생")
    @Test
    void failureExchangeManualLottoes() {
        assertThatThrownBy(() -> {
            lottoExchanger.exchange(Money.of(999), ManualLottoes.of(Arrays.asList("1, 2, 3, 4, 5, 6")));
        })
        .isInstanceOf(NotEnoughMoneyException.class)
        .hasMessageContaining("Money가 충분하지 않습니다.");
    }

    @DisplayName("Money를 지불하여 n개의 Lotto를 구매")
    @ParameterizedTest
    @CsvSource({
            "1000,1",
            "2000,2",
            "14000,14"
    })
    void successfulExchange(long moneyValue, int expected) {
        final Money money = Money.of(moneyValue);
        final List<Lotto> lottoes = lottoExchanger.exchange(money, ManualLottoes.empty());
        assertThat(lottoes).hasSize(expected);
    }
}
