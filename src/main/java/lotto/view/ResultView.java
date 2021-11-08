package lotto.view;

import lotto.domain.LottoResult;

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
                        "%d개 일치 (%d원)- %d개\n" +
                        "총 수익률은 %f입니다."
                , FOURTH_PLACE.getMatchCount(), FOURTH_PLACE.getPrizeMoney(), lottoResult.getResult(FOURTH_PLACE.getMatchCount())
                , THIRD_PLACE.getMatchCount(), THIRD_PLACE.getPrizeMoney(), lottoResult.getResult(THIRD_PLACE.getMatchCount())
                , SECOND_PLACE.getMatchCount(), SECOND_PLACE.getPrizeMoney(), lottoResult.getResult(SECOND_PLACE.getMatchCount())
                , FIRST_PLACE.getMatchCount(), FIRST_PLACE.getPrizeMoney(), lottoResult.getResult(FIRST_PLACE.getMatchCount())
                , lottoResult.getEarningsRate());
    }
}
