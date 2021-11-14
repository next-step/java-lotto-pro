package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    static List<LottoNumbers> generateLottoTicket() {
        return Stream.of(
                new LottoNumbers(asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(asList(11, 12, 13, 14, 15, 16)),
                new LottoNumbers(asList(21, 22, 23, 24, 25, 26)),
                new LottoNumbers(asList(31, 32, 33, 34, 35, 36)),
                new LottoNumbers(asList(41, 42, 43, 44, 45, 40))
        ).collect(toList());
    }

    @Test
    @DisplayName("5등이 2개 당첨된 경우")
    public void 로또들의_당첨_통계를_구한다() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(5000);
        LottoTicket lottoTicket = new LottoTicket(generateLottoTicket());
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 11, 12, 13)), LottoNumber.from(7));

        //when
        LottoResult lottoResult = LottoResult.of(lottoPurchase, lottoTicket, lottoWinningNumbers);


        Map<LottoRank, Long> rankResult = lottoResult.getRankResult();
        long count = rankResult.get(LottoRank.FIFTH);

        //then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("5000원으로 5등이 2개 당첨된 경우 수익률은 2이다.")
    public void 총_수익률을_계산한다() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(5000);
        LottoTicket lottoTicket = new LottoTicket(generateLottoTicket());
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 11, 12, 13)), LottoNumber.from(7));

        //when
        LottoResult lottoResult = LottoResult.of(lottoPurchase, lottoTicket, lottoWinningNumbers);

        //then
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(RateOfReturn.from(2));
    }

}