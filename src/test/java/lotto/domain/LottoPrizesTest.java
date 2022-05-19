package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizesTest {
    @Test
    @DisplayName("여러개의 LottoPrize을 생성한다")
    void create_success() {
        List<LottoPrize> lottoPrizeList = new ArrayList<>();
        lottoPrizeList.add(LottoPrize.WIN_WITH_3_MATCHES);
        lottoPrizeList.add(LottoPrize.WIN_WITH_3_MATCHES);

        LottoPrizes lottoPrizes = new LottoPrizes(lottoPrizeList);

        assertThat(lottoPrizes.size()).isEqualTo(2);
    }
}
