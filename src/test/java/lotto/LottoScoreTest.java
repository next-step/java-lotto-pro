package lotto;

import lotto.domain.LottoScore;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoScoreTest {
    @Test
    void calculatorProfit() {
        int amount = 1000;
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 1);
        LottoScore lottoScore = new LottoScore(map);
        assertThat(lottoScore.calculatorProfit(1000)).isEqualTo(5);
    }
}
