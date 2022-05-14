package lotto;

import lotto.model.LottoPrizeRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.model.LottoPrizeRank.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoPrizeRanks는 ")
public class LottoPrizeRanksTest {
    @DisplayName("총 당첨금액을 계산한다")
    @Test
    void calculate() {
        LottoPrizeRanks lottoPrizeRanks = new LottoPrizeRanks(Arrays.asList(
                THREE, FOUR, NONE));

        assertThat(lottoPrizeRanks.calculate()).isEqualTo(55000.0f);
    }
}
