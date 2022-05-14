package lotto.enums;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {
    @DisplayName("1등 당첨")
    @Test
    void test_1등_당첨() {
        assertThat(Rank.rank(6)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등 당첨")
    @Test
    void test_2등_당첨() {
        assertThat(Rank.rank(5)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등 당첨")
    @Test
    void test_3등_당첨() {
        assertThat(Rank.rank(4)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등 당첨")
    @Test
    void test_4등_당첨() {
        assertThat(Rank.rank(3)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("2개 일치 당첨 안됨")
    @Test
    void test_2개일치_당첨_안됨() {
        assertThat(Rank.rank(2)).isEqualTo(Rank.LOSE);
    }

    @DisplayName("1개 일치 당첨 안됨")
    @Test
    void test_1개일치_당첨_안됨() {
        assertThat(Rank.rank(1)).isEqualTo(Rank.LOSE);
    }

    @DisplayName("0개 일치 당첨 안됨")
    @Test
    void test_0개일치_당첨_안됨() {
        assertThat(Rank.rank(0)).isEqualTo(Rank.LOSE);
    }

    @DisplayName("매칭 개수가 벗어난 경우 예외 처리")
    @Test
    void test_범위_벗어난_매칭() {
        assertThatThrownBy(() -> Rank.rank(7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE_MATCH);
    }
}