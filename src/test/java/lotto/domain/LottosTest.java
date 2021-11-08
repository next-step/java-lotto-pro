package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    static List<Lotto> generateLottos() {
        return Stream.of(
                new Lotto(asList(1, 2, 3, 4, 5, 6)),
                new Lotto(asList(1, 2, 3, 4, 5, 16)),
                new Lotto(asList(1, 2, 3, 4, 15, 16)),
                new Lotto(asList(1, 2, 3, 14, 15, 16)),
                new Lotto(asList(11, 12, 13, 14, 15, 16))
        ).collect(toList());
    }

    @Test
    public void 총_당첨금을_계산한다() {
        //given
        Lottos lottos = new Lottos(generateLottos());
        LottoNumbers lottoWinningNumbers = new LottoNumbers(asList(1, 2, 3, 11, 12, 13));

        //when
        lottos.compareWinningNumbers(lottoWinningNumbers);

        //then
        assertThat(lottos.getTotalPrizeMoney()).isEqualTo(25000);
    }

    @Test
    public void 총_수익률을_계산한다() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(10000);
        Lottos lottos = new Lottos(generateLottos());
        LottoNumbers lottoWinningNumbers = new LottoNumbers(asList(1, 2, 3, 11, 12, 13));

        //when
        lottos.compareWinningNumbers(lottoWinningNumbers);

        //then
        assertThat(lottos.getRateOfReturn(lottoPurchase)).isEqualTo(2.5);
    }

    @Test
    public void 로또들의_당첨_통계를_구한다() {
        //given
        Lottos lottos = new Lottos(generateLottos());
        LottoNumbers lottoWinningNumbers = new LottoNumbers(asList(1, 2, 3, 11, 12, 13));

        //when
        lottos.compareWinningNumbers(lottoWinningNumbers);

        //then
        assertThat(lottos.getTotalRankCount(LottoRank.FOURTH)).isEqualTo(5);
    }

}