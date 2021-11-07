package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

class LottoMoneyTest {
    @DisplayName("로또 생성")
    @Test
    void constructLottoMoney() {
        LottoMoney lottoMoney = new LottoMoney(5000);
        assertThat(lottoMoney).isEqualTo(new LottoMoney(5000));
    }

    @DisplayName("텍스트 금액 입력 성공")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "14000"})
    void constructLottoMoney_success(String money) {
        assertThat(new LottoMoney(money)).isEqualTo(new LottoMoney(Integer.parseInt(money)));
    }

    @DisplayName("잘못된 값으로 금액 입력시 에러")
    @ParameterizedTest
    @ValueSource(strings = {"test", "-1", ""})
    void throwsError_whenInvalidMoney(String invalidMoney) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoMoney(invalidMoney))
            .withMessage("0 이상의 숫자를 입력해주세요.");
    }

    @DisplayName("구입 가능한 로또 개수 계산")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "0,0", "999,0", "1001,1"})
    void calculateLottoCount(String money, int lottoCount) {
        assertThat(new LottoMoney(money).calculateLottoCount()).isEqualTo(new LottoCount(lottoCount));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        assertThat(LottoMoney.calculateEarningRate(Arrays.asList(new LottoMoney(5000), new LottoMoney(150000))))
            .isEqualTo(new EarningRate(BigDecimal.valueOf(77.5)));
        assertThat(LottoMoney.calculateEarningRate(new ArrayList<>()))
            .isEqualTo(EarningRate.ZERO);
    }

    @DisplayName("로또 돈 메시지 생성")
    @Test
    void makePrintableMessage() {
        assertThat(new LottoMoney(5000).makePrintableMessage()).isEqualTo("5000원");
    }
}