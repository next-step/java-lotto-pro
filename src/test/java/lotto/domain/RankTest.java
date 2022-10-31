package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("일치하는 숫자로 Rank를 알 수 있다")
    @Test
    void rank_get_test() {
        int count = Rank.FIRST.getMatchCount();
        assertThat(Rank.get(count, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("티켓의 번호가 5개가 일치할 경우 순위는 3등이다")
    @Test
    void rank_get_match_five_test() {
        assertThat(Rank.get(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("보너스 볼이 일치하는 경우 순위는 2등이다")
    @Test
    void rank_get_bonus_test() {
        int count = Rank.FOURTH.getMatchCount();
        assertThat(Rank.get(count, true)).isEqualTo(Rank.SECOND);
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
