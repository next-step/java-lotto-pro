package lotto.view;

import lotto.domain.*;
import lotto.exception.LottoBallNumberConvertException;

import java.util.List;

public class ResultView {
    private static final String TRY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS = "당첨통계";

    public void printLottoTryCount(LottoGame lottoGame) {
        StringBuilder builder = new StringBuilder();
        builder.append(lottoGame.getTryCount()).append(TRY_COUNT_MESSAGE);
        System.out.println(builder.toString());
    }

    public void printLottoBalls(LottoGame lottoGame) {
        System.out.println(createLottoBallsListMessage(lottoGame));
    }

    public void printLottoResult(Money inputMoney, Statistics statistics) {
        System.out.println(STATISTICS);
        System.out.println("------------");
        System.out.println(createCountingMessage(3, statistics));
        System.out.println(createCountingMessage(4, statistics));
        System.out.println(createCountingMessage(5, statistics));
        System.out.println(createCountingMessage(6, statistics));
        System.out.println("총 수익률은 " + statistics.calculateEarningRate(inputMoney) + " 입니다.");
    }

    private String createCountingMessage(int count, Statistics statistics) {
        StringBuilder builder = new StringBuilder();
        Ranking ranking = Ranking.find(count);
        builder.append(count)
                .append("개 일치 (")
                .append(ranking.getPrize())
                .append("원) - ")
                .append(statistics.getCount(ranking));
        return builder.toString();
    }

    private String createLottoBallsListMessage(LottoGame lottoGame) {
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

    private String createLottoBallsMessage(LottoBalls lottoBalls) {
        return lottoBalls.getLottoBalls().stream()
                .map(lottoBall -> String.valueOf(lottoBall.getNumber()))
                .reduce((d1, d2) -> String.join(",", d1, d2))
                .orElseThrow(() -> new LottoBallNumberConvertException("로또 번호 문자열 변환 실패"));
    }
}
