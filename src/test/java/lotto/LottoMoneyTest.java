package lotto;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {
    @DisplayName("로또 생성")
    @Test
    void constructLottoMoney() {
        LottoMoney lottoMoney = new LottoMoney(5000);
        assertThat(lottoMoney).isEqualTo(new LottoMoney(5000));
    }

    @DisplayName("구입 가능한 로또 개수 계산")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "0,0", "999,0", "1001,1"})
    void calculateLottoCount(String moneyText, int lottoCount) {
        assertThat(new LottoMoney(moneyText).calculateLottoCount()).isEqualTo(new LottoCount(lottoCount));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        assertThat(LottoMoney.calculateEarningRate(Arrays.asList(new LottoMoney(5000), new LottoMoney(150000))))
            .isEqualTo(new EarningRate(BigDecimal.valueOf(77.5)));
    }

    @DisplayName("로또 돈 메시지 생성")
    @Test
    void makePrintableMessage() {
        assertThat(new LottoMoney(5000).makePrintableMessage()).isEqualTo("5000원");
    }
}