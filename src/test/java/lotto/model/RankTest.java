package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @DisplayName("로또 등수별 당첨금액 확인")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    public void checkWinningMoney(int sameCount, int winningMoney) {
        assertThat(Rank.matchCountOf(sameCount, false).winningMoney()).isEqualTo(winningMoney);
    }

    @Test
    @DisplayName("로또 2등 당첨금액 확인")
    public void checkSecondWinningMoney() {
        assertThat(Rank.matchCountOf(5, true).winningMoney()).isEqualTo(30000000);
    }
}
