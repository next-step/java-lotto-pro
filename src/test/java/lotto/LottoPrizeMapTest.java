package lotto;

import lotto.model.LottoPrizeMap;
import lotto.model.LottoPrizeRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.model.LottoPrizeRank.FOUR;
import static lotto.model.LottoPrizeRank.THREE;
import static lotto.model.LottoPrizeRank.NONE;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoPrizeMap은 ")
class LottoPrizeMapTest {
    @DisplayName("금액 별 당첨 갯수를 만든다")
    @Test
    void test() {
        LottoPrizeRanks lottoPrizeRanks = new LottoPrizeRanks(Arrays.asList(THREE, FOUR, NONE));

        assertThat(LottoPrizeMap.of(lottoPrizeRanks)).hasSize(2);
        assertThat(LottoPrizeMap.of(lottoPrizeRanks)).containsKeys(3, 4);
    }
}
