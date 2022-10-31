package lotto.domain.matcher.count;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchCountTest {

    @ParameterizedTest
    @DisplayName("보너스볼이 있을 경우 매치되는 숫자의 갯수")
    @CsvSource(value = {"3:2", "4:3", "5:4", "6:5"}, delimiter = ':')
    void isEquals_bonus(int matchCount, int expected) {
        assertThat(new MatchCount(matchCount, true).isEquals(expected)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("보너스볼이 없을 경우 매치되는 숫자의 갯수")
    @CsvSource(value = {"3:3", "4:4", "5:5", "6:6"}, delimiter = ':')
    void isEquals_no_bonus(int matchCount, int expected) {
        assertThat(new MatchCount(matchCount, false).isEquals(expected)).isTrue();
    }
}
