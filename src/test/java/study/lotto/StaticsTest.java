package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Money;
import study.lotto.domain.Rank;
import study.lotto.domain.Statics;

import static org.assertj.core.api.Assertions.assertThat;

class StaticsTest {

    @Test
    @DisplayName("수익율을 계산하는 테스트")
    void calculrateProfit_test() {
        Statics statics = new Statics(new Money("50000"));

        Rank.FOURTH.increaseCorrect();

        statics.calculateProfitRate();
        assertThat(statics.getProfitRate()).isEqualTo(1.00);
    }
}