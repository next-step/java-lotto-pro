package lotto.view;

import lotto.domain.LottoResult;

import static lotto.domain.LottoPrize.FIFTH_PLACE;
import static lotto.domain.LottoPrize.FIRST_PLACE;
import static lotto.domain.LottoPrize.FOURTH_PLACE;
import static lotto.domain.LottoPrize.SECOND_PLACE;
import static lotto.domain.LottoPrize.THIRD_PLACE;

public class ResultView {

    private ResultView() {
        throw new UnsupportedOperationException();
    }

    public static String print(LottoResult lottoResult) {
        return String.format("당첨 통계\n" +
                        "---------\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "%d개 일치, 보너스 볼 일치(%d원)- %d개\n" +
                        "%d개 일치 (%d원)- %d개\n" +
                        "총 수익률은 %f입니다."
                , FIFTH_PLACE.getMatchCount(), FIFTH_PLACE.getPrizeMoney(), lottoResult.getPrizeCount(FIFTH_PLACE)
                , FOURTH_PLACE.getMatchCount(), FOURTH_PLACE.getPrizeMoney(), lottoResult.getPrizeCount(FOURTH_PLACE)
                , THIRD_PLACE.getMatchCount(), THIRD_PLACE.getPrizeMoney(), lottoResult.getPrizeCount(THIRD_PLACE)
                , SECOND_PLACE.getMatchCount(), SECOND_PLACE.getPrizeMoney(), lottoResult.getPrizeCount(SECOND_PLACE)
                , FIRST_PLACE.getMatchCount(), FIRST_PLACE.getPrizeMoney(), lottoResult.getPrizeCount(FIRST_PLACE)
                , lottoResult.getEarningsRate());
    }
}
