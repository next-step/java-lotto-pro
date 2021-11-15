package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.exception.LottoException;

class MoneyTest {
    @DisplayName("로또 생성")
    @Test
    void constructMoney() {
        Money money = new Money(5000);
        assertThat(money).isEqualTo(new Money(5000));
    }

    @DisplayName("잘못된 값으로 금액 입력시 에러")
    @Test
    void throwsError_whenInvalidMoney() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new Money(-1))
            .withMessage("0 이상의 숫자를 입력해주세요.");
    }

    @DisplayName("구입 가능한 로또 개수 계산")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "0,0", "999,0", "1001,1"})
    void calculateCount(long money, int num) {
        assertThat(new Money(money).calculateCount()).isEqualTo(new TicketCount(num));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        assertThat(Money.calculateEarningRate(Arrays.asList(new Money(5000), new Money(150000))))
            .isEqualTo(new EarningRate(BigDecimal.valueOf(77.5)));

        assertThat(Money.calculateEarningRate(new ArrayList<>()))
            .isEqualTo(EarningRate.ZERO);
    }
}