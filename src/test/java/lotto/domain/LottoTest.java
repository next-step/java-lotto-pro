package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void countMatchingNumber_로또번호_일치() {
        Lotto lotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = WinningLotto.from("1,2,3,4,5,6", "7");
        MatchResult matchResult = winningLotto.countMatchingNumber(lotto);
        assertThat(matchResult.isResultMatch(6)).isTrue();
    }
}
