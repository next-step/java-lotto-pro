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

    @DisplayName("티켓의 번호가 5개가 일치하고 보너스 볼이 다를 경우 순위는 3등이다")
    @Test
    void rank_get_third_rank_test() {
        assertThat(Rank.get(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("티켓의 번호가 5개가 일치하고 보너스 볼이 일치하는 경우 순위는 2등이다")
    @Test
    void rank_get_second_rank_test() {
        assertThat(Rank.get(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("티켓의 번호가 5개가 일치하지 않으면 보너스 볼은 의미가 없다")
    @Test
    void rank_get_bonus_not_five_test() {
        assertThat(Rank.get(4, true)).isEqualTo(Rank.FOURTH);
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
