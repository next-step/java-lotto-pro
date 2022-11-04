package lotto;

import org.junit.jupiter.api.Test;

import static lotto.LottoMatchType.FIVE_BONUS;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTypeCounterTest {

    @Test
    void 로또_매치타입이_전달되면_내부_카운트정보를_하나씩_증가시킨다() {
        LottoMatchTypeCounter lottoMatchTypeCounter = new LottoMatchTypeCounter();

        lottoMatchTypeCounter.add(FIVE_BONUS);
        lottoMatchTypeCounter.add(FIVE_BONUS);
        lottoMatchTypeCounter.add(FIVE_BONUS);

        assertThat(lottoMatchTypeCounter.get(FIVE_BONUS)).isEqualTo(3);
    }
}
