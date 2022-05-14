package lotto;

import static generic.Money.wons;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import generic.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinResultTest {

    @ParameterizedTest
    @CsvSource(value = {"6;FIRST", "5;SECOND", "4;THIRD", "3;FOURTH", "2;NO_WIN", "0;NO_WIN"}, delimiterString = ";")
    @DisplayName("당첨 번호 갯수 별로 결과 생성")
    void confirm(int count, LottoWinResult expected) {
        // when & then
        assertThat(LottoWinResult.confirm(count)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST;1;2000000000", "FOURTH;10;50000"}, delimiterString = ";")
    @DisplayName("횟수 별로 당첨금 계산")
    void price(LottoWinResult winResult, long count, int price) {
        // when & then
        assertThat(winResult.price(count)).isEqualTo(wons(price));
    }
}