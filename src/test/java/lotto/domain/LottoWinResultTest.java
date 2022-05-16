package lotto.domain;

import static generic.Money.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import generic.Money;
import lotto.domain.LottoWinResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinResultTest {

    @ParameterizedTest
    @CsvSource(value = {"6;FIRST;false", "5;SECOND;true", "5;THIRD;false", "4;FOURTH;false", "3;FIFTH;false", "2;NO_WIN;false", "0;NO_WIN;false"}, delimiterString = ";")
    @DisplayName("당첨 번호 갯수 별로 결과 생성")
    void confirm(int count, LottoWinResult expected, boolean isCorrectBonusNumber) {
        // when & then
        assertThat(LottoWinResult.confirm(count, isCorrectBonusNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST;1;2000000000", "FOURTH;10;500000"}, delimiterString = ";")
    @DisplayName("횟수 별로 당첨금 계산")
    void price(LottoWinResult winResult, long count, int price) {
        // when & then
        assertThat(winResult.price(count)).isEqualTo(Money.valueOf(price));
    }
}