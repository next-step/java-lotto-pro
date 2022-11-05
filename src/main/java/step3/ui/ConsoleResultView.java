package step3.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import step3.domain.LotteryTicket;
import step3.domain.Lotto;
import step3.domain.Payment;
import step3.domain.Rank;
import step3.domain.Statistics;

public class ConsoleResultView implements ResultView {
    private static final String RESULT_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    private static final String RESULT_LOTTO = "[%s]%n";
    private static final String RESULT_STAT_TITLE = "당첨 통계";
    private static final String RESULT_STAT_LINE = "---------";
    private static final String RESULT_STAT_CONTENTS = "%d개 일치 (%d원)- %d개%n";
    private static final String RESULT_STAT_BONUS_CONTENTS = "%d개 일치, 보너스 볼 일치(%d원)- %d개%n";
    private static final String RESULT_STAT_RATIO = "총 수익률은 %.2f입니다.";
    private static final String RESULT_STAT_POSITIVE_CONCLUSION = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)";
    private static final String RESULT_STAT_NEGATIVE_CONCLUSION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String RESULT_STAT_EQUAL_CONCLUSION = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    private static final String REQUEST_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    public void resultLotteryTicket(LotteryTicket lotteryTicket, Payment payment) {
        System.out.printf(RESULT_COUNT, payment.getManualLottoCount(), payment.getAutoLottoCount());
        List<Lotto> lottos = lotteryTicket.getLotteryTicket();
        for (Lotto lotto : lottos) {
            String lottoNumber = lotto.numberToString();
            System.out.printf(RESULT_LOTTO, lottoNumber);
        }
    }

    public void resultStatistics(Statistics statistics, Payment payment) {
        System.out.println(RESULT_STAT_TITLE);
        System.out.println(RESULT_STAT_LINE);
        resultStatisticsContents(statistics);

        double ratio = (double) statistics.totalPrize() / payment.getPayment();

        System.out.printf(RESULT_STAT_RATIO, ratio);
        printConclusion(ratio);
    }

    public void printRequestManualNumber() {
        System.out.println(REQUEST_MANUAL_NUMBER);
    }

    private void printConclusion(double ratio) {
        if (ratio > 1) {
            System.out.println(RESULT_STAT_POSITIVE_CONCLUSION);
        }
        if (ratio < 1) {
            System.out.println(RESULT_STAT_NEGATIVE_CONCLUSION);
        }
        if (ratio == 1) {
            System.out.println(RESULT_STAT_EQUAL_CONCLUSION);
        }
    }

    private void resultStatisticsContents(Statistics statistics) {
        Map<Rank, Integer> countByRank = statistics.countByRank();
        ArrayList<Rank> keySet = new ArrayList<>(countByRank.keySet());
        Collections.sort(keySet);
        for (Rank rank : keySet) {
            System.out.printf(printContentsByRank(rank), rank.getCount(), rank.getPrize(), countByRank.get(rank));
        }
    }

    private String printContentsByRank(Rank rank) {
        if (rank == Rank.SECOND) {
            return RESULT_STAT_BONUS_CONTENTS;
        }
        return RESULT_STAT_CONTENTS;
    }

}
