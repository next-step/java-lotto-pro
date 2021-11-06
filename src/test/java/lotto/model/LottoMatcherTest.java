package lotto.model;

import static lotto.model.MatchCount.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoMatcherTest {
    private static final int PAYMENT = 14000;

    @Test
    void getMatchResult() {
        assertThat(new LottoMatcher(PAYMENT, 1, 2, 3, 4, 5, 6).getMatchResult(
            Arrays.asList(
                new LottoNumbers(1, 2, 3, 7, 8, 9),
                new LottoNumbers(1, 2, 3, 10, 11, 12),
                new LottoNumbers(1, 2, 3, 4, 5, 6)
            )
        )).isEqualTo(new MatchResult(new Payment(PAYMENT), THREE, THREE, SIX));
    }
}
