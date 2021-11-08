package lotto.model;

import static lotto.model.enums.MatchCount.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoMatcherTest {
    private static final Payment PAYMENT = new Payment(14000);

    @Test
    void getMatchResult() {
        assertThat(new LottoMatcher(1, 2, 3, 4, 5, 6).match(
            PAYMENT,
            Arrays.asList(
                new LottoNumbers(1, 2, 3, 7, 8, 9),
                new LottoNumbers(1, 2, 3, 10, 11, 12),
                new LottoNumbers(1, 2, 3, 4, 5, 6)
            )
        )).isEqualTo(new MatchResult(PAYMENT, THREE, THREE, SIX));
    }
}
