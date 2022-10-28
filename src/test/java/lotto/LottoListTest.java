package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {
    private final Rank first = Rank.SIX;
    private final Rank second = Rank.FIVE;
    private final Rank third = Rank.FOUR;
    private final Rank fourth = Rank.THREE;

    private final Lotto no1 = new Lotto(6);
    private final Lotto no2 = new Lotto(5);
    private final Lotto no3 = new Lotto(4);
    private final Lotto no4 = new Lotto(3);
    private final Lotto paper = new Lotto(0);

    @Test
    void 총_상금() {
        LottoList lottoList = new LottoList(Arrays.asList(no1, no2, no3));
        long expected = first.getPrize() + second.getPrize() + third.getPrize();
        assertThat(lottoList.getAllPrize()).isEqualTo(expected);

        lottoList = new LottoList(Arrays.asList(no1, no4, paper, paper));
        expected = first.getPrize() + fourth.getPrize();
        assertThat(lottoList.getAllPrize()).isEqualTo(expected);
    }

    @Test
    void 수익률() {
        assertThat(new LottoList(Arrays.asList(paper, paper, paper)).getReturnRate()).isEqualTo(0);
        assertThat(new LottoList(Arrays.asList(no4, paper, paper, paper, paper)).getReturnRate())
                .isEqualTo((double)fourth.getPrize() / 5 * Money.LOTTO_PRICE);
    }
}
