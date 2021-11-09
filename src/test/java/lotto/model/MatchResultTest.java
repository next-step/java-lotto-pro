package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.enums.Rank;

public class MatchResultTest {
    private static final int PAYMENT = 14000;
    private static final List<Rank> EXPECTED_RANKS = Arrays.asList(Rank.FIFTH, Rank.SECOND);
    private static final MatchResult EXPECTED_MATCH_RESULT = new MatchResult(new Payment(PAYMENT), EXPECTED_RANKS);

    @Test
    void getRateOfReturn() {
        double expectedRateOfReturn = (double)EXPECTED_RANKS.stream().mapToInt(Rank::getWinningMoney).sum() / PAYMENT;
        assertThat(EXPECTED_MATCH_RESULT.getRateOfReturn()).isEqualTo(expectedRateOfReturn);
    }

    @Test
    void isLosingMoney() {
        int expectedWinningMoney = EXPECTED_RANKS.stream().mapToInt(Rank::getWinningMoney).sum();
        assertThat(EXPECTED_MATCH_RESULT.isLosingMoney()).isEqualTo(expectedWinningMoney < PAYMENT);
    }

    @Test
    void getCount() {
        assertThat(EXPECTED_MATCH_RESULT.getCount(Rank.FIFTH)).isEqualTo(1);
    }
}
