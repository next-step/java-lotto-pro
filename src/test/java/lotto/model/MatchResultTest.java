package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.model.enums.Rank;

public class MatchResultTest {
    private static final int PAYMENT = 14000;
    private MatchResult matchResult;

    @BeforeEach
    void setUp() {
        matchResult = new MatchResult(new Payment(PAYMENT), Rank.FIFTH);
    }

    @Test
    void getRankToCount() {
        assertThat(matchResult.getRankToCount()).hasSize(Rank.values().length);
    }

    @Test
    void getRateOfReturn() {
        assertThat(matchResult.getRateOfReturn()).isEqualTo(((double)Rank.FIFTH.getWinningMoney()) / PAYMENT);
    }
}
