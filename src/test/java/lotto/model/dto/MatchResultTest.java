package lotto.model.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.model.dto.MatchResult;
import lotto.model.dto.Payment;
import lotto.model.dto.enums.MatchCount;

public class MatchResultTest {
    private static final int PAYMENT = 14000;
    private MatchResult matchResult;

    @BeforeEach
    void setUp() {
        matchResult = new MatchResult(new Payment(PAYMENT), MatchCount.THREE);
    }

    @Test
    void getMatchCountToCount() {
        assertThat(matchResult.getMatchCountToCount()).hasSize(MatchCount.values().length);
    }

    @Test
    void getRateOfReturn() {
        assertThat(matchResult.getRateOfReturn()).isEqualTo(((double)MatchCount.THREE.getPrizeMoney()) / PAYMENT);
    }
}
