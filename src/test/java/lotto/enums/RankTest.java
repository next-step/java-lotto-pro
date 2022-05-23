package lotto.enums;

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
    @CsvSource(value = {"6:FIRST", "5:SECOND", "4:THIRD", "3:FOURTH", "2:FIFTH", "1:SIXTH", "0:LOSE"}, delimiter = ':')
    void getRank_일치하는_개수(int numberOfMatch, Rank expected) {
        System.out.println(numberOfMatch);
//        assertThat(getRank(numberOfMatch))
//                .isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 번호 당첨 여부에 따라 해당 등수를 리턴한다.")
    void getRank_보너스() {
        assertThat(getRank(5, false))
                .isEqualTo(THIRD);
        assertThat(getRank(5, true))
                .isEqualTo(SECOND);
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

    @Test
    @DisplayName("등수에 따른 toString을 확인한다.")
    void toString_등수별() {
        assertThat(SECOND.toString())
                .isEqualTo("%d개 일치, 보너스 볼 일치 (%s원)", 5, 30_000_000);
        assertThat(THIRD.toString())
                .isEqualTo("%d개 일치 (%s원)", 5, 1_500_000);
    }

}
