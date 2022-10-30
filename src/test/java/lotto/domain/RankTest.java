package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("랭크 최소값과 비교할 수 있다")
    @Test
    void isBiggerThanMinimum_test() {
        assertThat(Rank.isBiggerThanMinimum(2)).isFalse();
        assertThat(Rank.isBiggerThanMinimum(3)).isTrue();
    }

    @DisplayName("일치하는 숫자로 Rank를 알 수 있다")
    @Test
    void rank_get_test() {
        int count = Rank.FIRST.getMatchCount();
        assertThat(Rank.get(count)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("각 랭크의 일치하는 숫자를 알 수 있다")
    @Test
    void matchCount_test() {
        assertThat(Rank.FIRST.getMatchCount()).isEqualTo(6);
    }

    @DisplayName("각 랭크의 가격을 알 수 있다")
    @Test
    void price_test() {
        assertThat(Rank.FIRST.getMoney()).isEqualTo(new Money(2_000_000_000L));
    }
}
