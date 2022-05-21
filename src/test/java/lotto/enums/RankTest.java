package lotto.enums;

import lotto.model.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static lotto.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("일치하는 개수에 따라 적절한 랭킹을 리턴하는지 확인한다.")
    @CsvSource({"6, FIRST", "4, FOURTH", "3, FIFTH", "2, SIXTH", "1, SEVENTH", "0, LOSE"})
    void getRank_일치하는_개수(int numberOfMatch, Rank expected) {
        assertThat(getRank(numberOfMatch))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("해당 등수의 총 당첨금액을 계산하여 리턴한다.")
    void getPrizeWithCount_총_당첨금액() {
        assertThat(THIRD.getPrizeWithCount(3))
                .isEqualTo(Prize.of(4_500_000));
    }

    @ParameterizedTest
    @DisplayName("당첨 및 낙첨 여부를 판단한다(당첨).")
    @EnumSource(value = Rank.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"})
    void isOverMinWinningRank_당첨(Rank rank) {
        assertThat(rank.isOverMinWinningRank())
                .isTrue();

    }

    @ParameterizedTest
    @DisplayName("당첨 및 낙첨 여부를 판단한다(낙첨).")
    @EnumSource(value = Rank.class, names = {"SIXTH", "SEVENTH", "LOSE"})
    void isOverMinWinningRank_낙첨(Rank rank) {
        assertThat(rank.isOverMinWinningRank())
                .isFalse();
    }


}
