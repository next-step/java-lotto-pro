package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void countMatchingNumber_로또번호_일치() {
        Lotto lotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        Lotto winningLotto = Lotto.from("1,2,3,4,5,6", "7");
        MatchResult matchResult = winningLotto.countMatchingNumber(lotto);
        assertThat(matchResult.isResultMatch(6)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validate_예외_6자리_아닌_로또_번호_입력(String input) {
        assertThatThrownBy(() -> Lotto.from(input, "1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The lottery must consist of 6 digits.");
    }

    @Test
    void validate_예외_중복된_로또_번호_입력() {
        assertThatThrownBy(() -> Lotto.from("1,2,2,2,4,5", "1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The lottery must not have duplicate numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void validate_예외_당첨번호_보너스볼_중복(String str) {
        assertThatThrownBy(() -> Lotto.from("1,2,3,4,5,6", str)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Bonus numbers are duplicated in lottery numbers.");
    }
}
