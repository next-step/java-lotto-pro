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
        WinningLotto winningLotto = WinningLotto.from("1,2,3,4,5,6", "7");
        MatchResult matchResult = winningLotto.countMatchingNumber(lotto);
        assertThat(matchResult.isResultMatch(6)).isTrue();
    }
}
