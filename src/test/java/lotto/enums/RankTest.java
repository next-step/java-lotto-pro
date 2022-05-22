package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static lotto.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("일치하는 개수에 따라 적절한 랭킹을 리턴하는지 확인한다.")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH", "2, FIFTH", "1, SIXTH", "0, LOSE"})
    void getRank_일치하는_개수(int numberOfMatch, Rank expected) {
        assertThat(getRank(numberOfMatch))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("당첨 및 낙첨 여부를 판단한다(당첨).")
    @EnumSource(value = Rank.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH"})
    void isOverMinWinningRank_당첨(Rank rank) {
        assertThat(rank.isOverMinWinningRank())
                .isTrue();

    }

    @ParameterizedTest
    @DisplayName("당첨 및 낙첨 여부를 판단한다(낙첨).")
    @EnumSource(value = Rank.class, names = {"FIFTH", "SIXTH", "LOSE"})
    void isOverMinWinningRank_낙첨(Rank rank) {
        assertThat(rank.isOverMinWinningRank())
                .isFalse();
    }

}
