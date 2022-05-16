package lotto.view;

import java.util.Map;
import lotto.controller.dto.LottoResultDTO;
import lotto.enums.LottoRank;

public class OutputView {

    private static final String PURCHASED_TICKETS_NUMBER = "%s개를 구매했습니다.";
    private static final String RESULT_PRIZED_RATE = "당첨 통계";
    private static final String LINE_STRING = "---------";
    private static final String TOTAL_WINNING_COUNT = "%s개 일치 (%s원)- %s개";
    private static final String SECOND_WINNING_COUNT = "%s개 일치, 보너스 볼 일치 (%s원)- %s개";
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String BENEFIT = "이익이";
    private static final String LOSS = "손해";


    private static final int BENEFIT_STANDARD = 1;

    public static void printPurchasedTicketsCount(int ticketCount) {
        System.out.printf(PURCHASED_TICKETS_NUMBER, ticketCount);
        System.out.println();
    }

    public static void printTicketsNumbers(String numberString) {
        System.out.println(numberString);
    }

    public static void printTotalString() {
        System.out.println(RESULT_PRIZED_RATE);
        System.out.println(LINE_STRING);
    }

    public static void printTotalWinningCount(int countOfMatch, int winningMoney, int winningCount) {
        System.out.printf(TOTAL_WINNING_COUNT, countOfMatch, winningMoney, winningCount);
        System.out.println();
    }

    public static void printSecondWinningCount(int countOfMatch, int winningMoney, int winningCount) {
        System.out.printf(SECOND_WINNING_COUNT, countOfMatch, winningMoney, winningCount);
        System.out.println();
    }

    public static void printTotalProfitRate(double profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE, profitRate, profitRate > BENEFIT_STANDARD ? BENEFIT : LOSS);
        System.out.println();
    }

    public static void printResultReporting(LottoResultDTO resultDTO) {
        printTotalString();
        Map<LottoRank, Integer> resultMap = resultDTO.getResultMap();
        for (LottoRank lottoRank : resultMap.keySet()) {
            printWinningStatistics(resultMap, lottoRank);
        }
        printTotalProfitRate(resultDTO.getProfitRate());
    }

    private static void printWinningStatistics(Map<LottoRank, Integer> resultMap, LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.SECOND)) {
            printSecondWinningCount(lottoRank.getCountOfMatch(), lottoRank.getWinningMoney(),
                    resultMap.get(lottoRank));
            return;
        }
        printTotalWinningCount(lottoRank.getCountOfMatch(), lottoRank.getWinningMoney(), resultMap.get(lottoRank));
    }
}
