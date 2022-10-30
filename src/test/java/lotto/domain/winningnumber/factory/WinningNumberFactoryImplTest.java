package lotto.domain.winningnumber.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberFactoryImplTest {

    @ParameterizedTest
    @DisplayName("당첨번호와 로또번호의 맞춘 갯수를 확인")
    @CsvSource(value = {"1,2,3,4,5,6:6", "6,5,4,3,2,1:6", "7,8,9,10,11,12:0"}, delimiter = ':')
    void matchNumber(String winningNumber, int expected) {
        assertThat(new WinningNumberFactoryImpl(winningNumber).createWinningNumber()
                .matchNumber(Arrays.asList(1, 2, 3, 4, 5, 6).iterator()))
                .isEqualTo(expected);
    }
}
