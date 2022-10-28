package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {
    @Test
    void 총_상금() {
        Rank first = Rank.SIX;
        Rank second = Rank.FIVE;
        Rank third = Rank.FOUR;
        Rank fourth = Rank.THREE;

        Lotto no1 = new Lotto(6);
        Lotto no2 = new Lotto(5);
        Lotto no3 = new Lotto(4);
        Lotto no4 = new Lotto(3);
        Lotto paper = new Lotto(0);

        LottoList lottoList = new LottoList(Arrays.asList(no1, no2, no3));
        long expected = first.getPrize() + second.getPrize() + third.getPrize();
        assertThat(lottoList.getAllPrize()).isEqualTo(expected);

        lottoList = new LottoList(Arrays.asList(no1, no4, paper, paper));
        expected = first.getPrize() + fourth.getPrize();
        assertThat(lottoList.getAllPrize()).isEqualTo(expected);
    }
}
