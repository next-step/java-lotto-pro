package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusTest {

    @DisplayName("보너스 볼이 맞았는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "3:3:true", "1:3:false" }, delimiter = ':')
    void 보너스_볼_확인(int bonus, int checkNumber, boolean expected) {
        assertThat(Bonus.from(bonus).isMatchBonus(checkNumber)).isEqualTo(expected);
    }

}
