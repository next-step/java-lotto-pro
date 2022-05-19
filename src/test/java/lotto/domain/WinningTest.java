package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @ParameterizedTest
    @CsvSource(value = {"6,2000000000", "4,50000", "3,5000"})
    void 일치개수_당첨금(int match, int expected) {
        assertThat(Winning.from(match, true).getMoney()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,false,1500000", "5,true,30000000"})
    void 일치개수_보너스_당첨금(int match, boolean bonus, int expected) {
        assertThat(Winning.from(match, bonus).getMoney()).isEqualTo(expected);
    }
}
