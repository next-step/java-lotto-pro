package step3.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoCount;
import step3.domain.Money;

class LottoControllerTest {

    @ParameterizedTest(name = "입력된 금액에 따른 구입가능한 자동로또 개수를 반환한다. ({0} : {1})")
    @CsvSource(value = {"2000:1", "5000:4", "100:0"}, delimiter = ':')
    void 구입가능한_자동로또_개수_반환(int inputMoney, int expected) {
        Money money = new Money(inputMoney);
        LottoCount autoLottoCount = LottoController.autoLottoCount(money, new LottoCount(1));
        assertThat(autoLottoCount.get()).isEqualTo(expected);
    }

    @DisplayName("실제 로또를 구입하는데 투자된 금액을 계산한다.")
    @Test
    void 투자금액_계산() {
        assertThat(LottoController.totalInvestmentAmount(new LottoCount(4), new LottoCount(1))).isEqualTo(5_000);
    }

}