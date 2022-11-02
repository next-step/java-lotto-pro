package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningMoneyEnumTest {

    @ParameterizedTest
    @CsvSource(value = {"1:5000", "2:10000", "5:25000", "10:50000"}, delimiterString = ":")
    @DisplayName("5등의 당첨금을 계산한다.")
    void fifth(int count, long result){
        assertThat(LottoWinningMoneyEnum.calculateWinningMoneyByContainCount(3, count)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:50000", "2:100000", "5:250000", "10:500000"}, delimiterString = ":")
    @DisplayName("4등의 당첨금을 계산한다.")
    void fourth(int count, long result){
        assertThat(LottoWinningMoneyEnum.calculateWinningMoneyByContainCount(4, count)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1500000", "2:3000000", "5:7500000", "10:15000000"}, delimiterString = ":")
    @DisplayName("3등의 당첨금을 계산한다.")
    void third(int count, long result){
        assertThat(LottoWinningMoneyEnum.calculateWinningMoneyByContainCount(5, count)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2000000000", "2:4000000000", "5:10000000000", "10:20000000000"}, delimiterString = ":")
    @DisplayName("1등의 당첨금을 계산한다.")
    void first(int count, long result){
        assertThat(LottoWinningMoneyEnum.calculateWinningMoneyByContainCount(6, count)).isEqualTo(result);
    }
}
