package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StaticsTest {

    @Test
    @DisplayName("수익율을 계산하는 테스트")
    void calculrateProfit_test() {
        Statics statics = new Statics(new Money("50000"));

        Map<Rank, Count> matchCounter = statics.getMatchCounter();
        matchCounter.put(Rank.FOURTH, new Count().increase());
        statics.calculateProfitRate();

        assertThat(statics.getProfitRate()).isEqualTo(1.00);
    }
}