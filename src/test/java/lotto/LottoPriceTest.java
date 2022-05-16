package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPriceTest {

    @ParameterizedTest
    @CsvSource(value = {"14000,14, 1000,1, 1500,1, 500,0"})
    public void calculateNumberOfLottoCanBuy(int money, int countOfLotto) {
        assertThat(LottoPrice.numberOfLottoCanBuy(money)).isEqualTo(countOfLotto);
    }
}
