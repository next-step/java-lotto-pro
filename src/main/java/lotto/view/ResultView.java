package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final int BEP = 1;
    public static final String GAME_RESULT_VIEW_1 = "개 일치 (";
    public static final String GAME_RESULT_VIEW_2 = "원)- ";
    public static final String GAME_RESULT_VIEW_3 = "개\n";
    public static final String JOIN_DELIMITER = "\n";
    private final Prize threeMatchPrize = Prize.THREE_MATCH_PRIZE;
    private final Prize fourMatchPrize = Prize.FOUR_MATCH_PRIZE;
    private final Prize fiveMatchPrize = Prize.FIVE_MATCH_PRIZE;
    private final Prize sixMatchPrize = Prize.SIX_MATCH_PRIZE;

    public ResultView() {
    }

    public void printBuyResult(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.count() + "개를 구매했습니다.");
        String lottoResultStrings = getLottoResultString(lottoTickets);
        System.out.println(lottoResultStrings);
    }

    public String getLottoResultString(LottoTickets lottoTickets) {
        List<String> resultStrings = lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicket::toResultString)
                .collect(Collectors.toList());
        return String.join(JOIN_DELIMITER, resultStrings);
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println(threeMatchPrize.getMatchCount() + GAME_RESULT_VIEW_1 + threeMatchPrize.getPrizeMoney() + GAME_RESULT_VIEW_2 + gameResult.getMatchCount(threeMatchPrize.getMatchCount()) + GAME_RESULT_VIEW_3 +
                fourMatchPrize.getMatchCount() + GAME_RESULT_VIEW_1 + fourMatchPrize.getPrizeMoney() + GAME_RESULT_VIEW_2 + gameResult.getMatchCount(fourMatchPrize.getMatchCount()) + GAME_RESULT_VIEW_3 +
                fiveMatchPrize.getMatchCount() + GAME_RESULT_VIEW_1 + fiveMatchPrize.getPrizeMoney() + GAME_RESULT_VIEW_2 + gameResult.getMatchCount(fiveMatchPrize.getMatchCount()) + GAME_RESULT_VIEW_3 +
                sixMatchPrize.getMatchCount() + GAME_RESULT_VIEW_1 + sixMatchPrize.getPrizeMoney() + GAME_RESULT_VIEW_2 + gameResult.getMatchCount(sixMatchPrize.getMatchCount()) + GAME_RESULT_VIEW_3);
    }

    public void printEarningRatio(Money inputMoney, Money prize) {
        double earningRatio = (double) prize.get() / inputMoney.get();
        String result = "총 수익률은 " + earningRatio + "입니다. ";
        if (earningRatio < BEP) {
            result += "기준이 1이기 때문에 결과적으로 손해라는 의미임";
        }
        System.out.print(result);
    }
}
