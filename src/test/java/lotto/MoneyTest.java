package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.LottoManager;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @Test
    public void makeMoney() {
        //given
        Money expected = new Money(1000);
        //when
        Money actual = new Money(1000);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void minusMoney() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Money(-1000));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,14, 1000,1, 1500,1, 500,0"})
    public void calculateNumberOfLottoCanBuy(int money, int countOfLotto) {
        LottoManager lottoManager = new LottoManager();
        assertThat(lottoManager.numberOfLottoCanBuy(new Money(money))).isEqualTo(countOfLotto);
    }
}
