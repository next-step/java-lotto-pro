package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {
    @DisplayName("로또 생성 테스트")
    @Test
    void constructLottoMoney_success() {
        LottoMoney lottoMoney = new LottoMoney(5000);
        assertThat(lottoMoney).isEqualTo(new LottoMoney(5000));
    }

    @DisplayName("로또 개수 계산")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "0,0", "999,0", "1001,1"})
    void calculateLottoCount_success(String moneyText, int lottoCount) {
        assertThat(new LottoMoney(moneyText).calculateLottoCount()).isEqualTo(new LottoCount(lottoCount));
    }

    @DisplayName("로또 돈 곱하기 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void calculateMultiple_success(int multiple) {
        assertThat(new LottoMoney(5000).calculateMultiple(multiple)).isEqualTo(new LottoMoney(5000 * multiple));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateEarningRate_success() {
        assertThat(LottoMoney.calculateEarningRate(Arrays.asList(new LottoMoney(5000), new LottoMoney(150000))))
            .isEqualTo(new EarningRate(77.5));
    }

    @DisplayName("로또 돈 메시지 출력 테스트")
    @Test
    void makePrintableMessage() {
        assertThat(new LottoMoney(5000).makePrintableMessage()).isEqualTo("5000원");
    }
}