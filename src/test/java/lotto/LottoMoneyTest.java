package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "0,0", "999,0", "1001,1"})
    void calculateLottoCount_success(String moneyText, int lottoCount) {
        assertThat(new LottoMoney(moneyText).calculateLottoCount()).isEqualTo(new LottoCount(lottoCount));
    }
}