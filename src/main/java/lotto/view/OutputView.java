package lotto.view;

import java.util.StringJoiner;

import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.MatchResult;
import lotto.model.RateOfReturn;
import lotto.model.enums.Rank;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String NORMAL_MATCH_STATEMENT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String SECOND_MATCH_STATEMENT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String RATE_OF_RETURN_STATEMENT_FORMAT = "총 수익률은 %s입니다.";
    private static final String SUCCESS_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임)";
    private static final String FAILURE_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printLottoPurchase(Lottos lottos, LottoCount lottoCount) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        String numberOfLottoStatement = String.format(
            NUMBER_OF_LOTTO_FORMAT, lottoCount.getManualCount(), lottoCount.getAutoCount());
        stringJoiner.add(numberOfLottoStatement);
        stringJoiner.add(lottos.toString());
        System.out.println(stringJoiner);
        System.out.println();
    }

    public static void printLottoResult(MatchResult matchResult) {
        System.out.println();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(RESULT_HEADER);
        for (Rank rank : Rank.getRanksHavingWinningMoney()) {
            int totalCount = matchResult.countRank(rank);
            String matchStatement = String.format(
                getMatchStatementFormat(rank), rank.getCountOfMatch(), rank.getWinningMoney(), totalCount);
            stringJoiner.add(matchStatement);
        }
        stringJoiner.add(computeRateOfReturnStatement(matchResult.getRateOfReturn()));
        System.out.println(stringJoiner);
    }

    private static String getMatchStatementFormat(Rank rank) {
        if (rank.isSecond()) {
            return SECOND_MATCH_STATEMENT_FORMAT;
        }
        return NORMAL_MATCH_STATEMENT_FORMAT;
    }

    private static String computeRateOfReturnStatement(RateOfReturn rateOfReturn) {
        return String.format(RATE_OF_RETURN_STATEMENT_FORMAT, rateOfReturn) + getTrailingStatement(rateOfReturn);
    }

    private static String getTrailingStatement(RateOfReturn rateOfReturn) {
        if (rateOfReturn.isLosingMoney()) {
            return FAILURE_STATEMENT;
        }
        return SUCCESS_STATEMENT;
    }
}
