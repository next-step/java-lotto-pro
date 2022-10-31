package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MatchCountTest {

    @Test
    @DisplayName("로또숫자 일치 개수 생성 작업이 정상적으로 동작한다.")
    public void constructor() {
        assertThat(new MatchCount(6, true).getMatchBallCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또숫자 일치 개수의 비교 작업이 정상적으로 동작한다.")
    public void equals() {
        MatchCount countOfFirstRank1 = new MatchCount(6, true);
        MatchCount countOfFirstRank2 = new MatchCount(6, false);
        MatchCount countOfSecondRank = new MatchCount(5, true);
        MatchCount countOfThirdRank = new MatchCount(5, false);

        assertAll(
                () -> assertThat(countOfFirstRank1.equals(countOfFirstRank2)).isTrue(),
                () -> assertThat(countOfSecondRank.equals(countOfThirdRank)).isFalse()
        );
    }
}
