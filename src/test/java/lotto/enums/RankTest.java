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
        //given & when & then
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등 당첨")
    @Test
    void test_2등_당첨() {
        //given & when & then
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등 당첨")
    @Test
    void test_3등_당첨() {
        //given & when & then
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등 당첨")
    @Test
    void test_4등_당첨() {
        //given & when & then
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("5등 당첨")
    @Test
    void test_5등_당첨() {
        //given & when & then
        assertThat(Rank.rank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 일치 당첨 안됨")
    @Test
    void test_2개일치_당첨_안됨() {
        //given & when & then
        assertThat(Rank.rank(2, false)).isEqualTo(Rank.MISS);
    }

    @DisplayName("1개 일치 당첨 안됨")
    @Test
    void test_1개일치_당첨_안됨() {
        //given & when & then
        assertThat(Rank.rank(1, false)).isEqualTo(Rank.MISS);
    }

    @DisplayName("0개 일치 당첨 안됨")
    @Test
    void test_0개일치_당첨_안됨() {
        //given & when & then
        assertThat(Rank.rank(0, false)).isEqualTo(Rank.MISS);
    }

    @DisplayName("매칭 개수가 벗어난 경우 예외 처리")
    @Test
    void test_범위_벗어난_매칭() {
        //given & when & then
        assertThatThrownBy(() -> Rank.rank(7, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE_MATCH);
    }
}