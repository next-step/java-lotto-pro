package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @Test
    void isResultMatch_로또번호_숫자결과_일치() {
        MatchResult matchResult = MatchResult.from(5, true);
        assertThat(matchResult.isResultMatch(5)).isTrue();
        assertThat(matchResult.isBonusMatch(true)).isTrue();
    }
}
