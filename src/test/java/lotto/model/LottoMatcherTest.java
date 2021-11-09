package lotto.model;

import static lotto.model.LottoMatcher.*;
import static lotto.model.enums.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoMatcherTest {
    private static final Payment PAYMENT = new Payment(14000);

    @Test
    void 객체_생성_시_유효성_검사() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoMatcher(6, 1, 2, 3, 4, 5, 6)
        ).withMessageContaining(DUPLICATE_BONUS_NUMBER_ERR_MSG);
    }

    @Test
    void getMatchResult() {
        assertThat(new LottoMatcher(7, 1, 2, 3, 4, 5, 6).match(
            PAYMENT,
            Arrays.asList(
                new LottoNumbers(1, 2, 3, 7, 8, 9),
                new LottoNumbers(1, 2, 3, 4, 5, 11),
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(1, 2, 3, 4, 5, 7)
            )
        )).isEqualTo(new MatchResult(PAYMENT, FIFTH, THIRD, FIRST, SECOND));
    }
}
