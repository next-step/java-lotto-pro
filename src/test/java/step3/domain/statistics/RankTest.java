package step3.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static step3.domain.statistics.Rank.isSecond;
import static step3.domain.statistics.Rank.valueOf;

class RankTest {

    @Test
    @DisplayName("당첨 번호 일치 개수에 따라 로또 당첨 유형을 리턴한다.")
    void rankFifth() {
        Rank rank = valueOf(new Match(3, false));
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("5개 번호, 보너스 번호가 일치하는 경우 2등을 리턴한다.")
    void rankSecond() {
        Rank rank = valueOf(new Match(5, true));
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치하는 경우 3등을 리턴한다.")
    void rankThird() {
        Rank rank = valueOf(new Match(5, false));
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("일치 카운트가 2등의 카운트와 일치하는지 판단한다.")
    void isSecondByCount() {
        assertTrue(isSecond(5));
    }

    @Test
    @DisplayName("카운트가 0~2개인 경우 0개로 처리한다.")
    void count() {
        Match match = new Match(2, false);
        assertThat(match.getCount()).isEqualTo(0);
    }
}
