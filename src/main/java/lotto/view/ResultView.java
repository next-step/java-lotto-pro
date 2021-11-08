package lotto.view;

import lotto.domain.*;
import lotto.exception.ErrorCode;
import lotto.exception.ExecutePrivateConstructorException;
import lotto.exception.LottoBallNumberConvertException;

import java.util.List;

public class ResultView {
    private static final String TRY_COUNT_MANUAL_MESSAGE = "수동으로 ";
    private static final String TRY_COUNT_AUTO_MESSAGE = "자동으로 ";
    private static final String TRY_COUNT_MIDDLE_MESSAGE = "개, ";
    private static final String TRY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS = "당첨통계";
    private static final String STATISTICS_COUNT_MESSAGE = "개 일치 (";
    private static final String STATISTICS_SECOND_BONUS_MESSAGE = "개 일치, 보너스볼 일치(";
    private static final String STATISTICS_PRICE_MESSAGE = "원) - ";

    private ResultView() {
        throw new ExecutePrivateConstructorException(ErrorCode.OUTPUT_VIEW.getMsg());
    }

    public static void printLottoTryCount(LottoGame lottoGame) {
        StringBuilder builder = new StringBuilder();
        builder.append(TRY_COUNT_MANUAL_MESSAGE).append(lottoGame.getManualTryCount()).append(TRY_COUNT_MIDDLE_MESSAGE);
        builder.append(TRY_COUNT_AUTO_MESSAGE).append(lottoGame.getAutoTryCount()).append(TRY_COUNT_MESSAGE);
        System.out.println(builder.toString());
    }

    public static void printLottoBalls(LottoGame lottoGame) {
        System.out.println(createLottoBallsListMessage(lottoGame));
    }

    public static void printLottoResult(Money inputMoney, Statistics statistics) {
        System.out.println(STATISTICS);
        System.out.println("------------");
        System.out.println(createCountingMessage(Ranking.FOURTH, statistics));
        System.out.println(createCountingMessage(Ranking.THIRD, statistics));
        System.out.println(createCountingMessage(Ranking.SECOND, statistics));
        System.out.println(createCountingMessage(Ranking.SECOND_BONUS, statistics));
        System.out.println(createCountingMessage(Ranking.FIRST, statistics));
        System.out.println("총 수익률은 " + statistics.calculateEarningRate(inputMoney) + " 입니다.");
    }

    private static String createCountingMessage(Ranking ranking, Statistics statistics) {
        StringBuilder builder = new StringBuilder();
        builder.append(ranking.getCount())
                .append(chooseMessage(ranking))
                .append(ranking.getPrize())
                .append(STATISTICS_PRICE_MESSAGE)
                .append(statistics.getCount(ranking));
        return builder.toString();
    }

    private static String chooseMessage(Ranking ranking) {
        if (ranking == Ranking.SECOND_BONUS) {
            return STATISTICS_SECOND_BONUS_MESSAGE;
        }
        return STATISTICS_COUNT_MESSAGE;
    }

    private static String createLottoBallsListMessage(LottoGame lottoGame) {
        List<LottoBalls> lottoBallsList = lottoGame.getLottoBallsList();
        StringBuilder builder = new StringBuilder();
        for (LottoBalls lottoBalls : lottoBallsList) {
            builder.append("[");
            builder.append(createLottoBallsMessage(lottoBalls));
            builder.append("]");
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String createLottoBallsMessage(LottoBalls lottoBalls) {
        return lottoBalls.getLottoBalls().stream()
                .map(lottoBall -> String.valueOf(lottoBall.getNumber()))
                .reduce((d1, d2) -> String.join(",", d1, d2))
                .orElseThrow(() -> new LottoBallNumberConvertException("로또 번호 문자열 변환 실패"));
    }
}
