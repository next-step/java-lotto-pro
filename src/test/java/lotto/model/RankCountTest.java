package lotto.model;

import lotto.enums.Rank;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import static lotto.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankCountTest {

    @Test
    @DisplayName("수익률 계산 로직을 확인한다.")
    void earningRate_수익률_계산() {
        Purchase purchase = Purchase.createPurchase(10000);
        RankCount rankCount = RankCount.from(new LinkedHashMap<Rank, Integer>() {{
            put(THIRD, 1);  //  1_500_000
            put(SECOND, 1); // 30_000_000
        }});

        Earning earningRate = rankCount.earningRate(purchase);

        assertThat(earningRate.getEarningRate())
                .isCloseTo(BigDecimal.valueOf(3150), Percentage.withPercentage(100));
    }
}
