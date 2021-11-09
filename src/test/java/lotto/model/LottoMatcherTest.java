package lotto.model;

import static lotto.model.LottoMatcher.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.enums.Rank;

public class LottoMatcherTest {
    private static final Payment PAYMENT = new Payment(14000);

    @Test
    @DisplayName("보너스 번호와 당첨번호가 겹칠 때 예외를 발생시킨다")
    void 객체_생성_시_유효성_검사() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoMatcher(6, 1, 2, 3, 4, 5, 6)
        ).withMessageContaining(DUPLICATE_BONUS_NUMBER_ERR_MSG);
    }

    @Test
    void match() {
        assertThat(new LottoMatcher(7, 1, 2, 3, 4, 5, 6).match(
            PAYMENT,
            Arrays.asList(
                new LottoNumbers(1, 2, 3, 7, 8, 9),
                new LottoNumbers(1, 2, 3, 4, 5, 11),
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(1, 2, 3, 4, 5, 7),
                new LottoNumbers(1, 2, 9, 10, 11, 12)
            )
        )).isEqualTo(new MatchResult(PAYMENT, Rank.FIFTH, Rank.THIRD, Rank.FIRST, Rank.SECOND, Rank.MISS));
    }
}
