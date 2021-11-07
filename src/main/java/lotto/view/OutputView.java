package lotto.view;

import static lotto.model.enums.MatchCount.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

import lotto.model.LottoNumbers;
import lotto.model.MatchResult;
import lotto.model.enums.MatchCount;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_STATEMENT_FORMAT = "%d개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String MATCH_STATEMENT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String RATE_OF_RETURN_STATEMENT_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String SUCCESS_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임)";
    private static final String FAILURE_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printLottoPurchase(Collection<LottoNumbers> numbersCollection) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(String.format(NUMBER_OF_LOTTO_STATEMENT_FORMAT, numbersCollection.size()));
        for (LottoNumbers lottoNumbers : numbersCollection) {
            stringJoiner.add(lottoNumbers.toString());
        }
        System.out.println(stringJoiner);
        System.out.println();
    }

    public static void printLottoResult(MatchResult matchResult) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(RESULT_HEADER);
        for (MatchCount matchCount : getMatchCountsWithWinningMoney()) {
            stringJoiner.add(
                String.format(MATCH_STATEMENT_FORMAT, matchCount.getCountOfMatch(), matchCount.getWinningMoney(),
                    matchResult.getMatchCountToCount().get(matchCount)));
        }
        stringJoiner.add(String.format(RATE_OF_RETURN_STATEMENT_FORMAT, matchResult.getRateOfReturn()));
        System.out.println();
        System.out.println(stringJoiner + getTrailingStatement(matchResult.getRateOfReturn()));
    }

    private static List<MatchCount> getMatchCountsWithWinningMoney() {
        return Arrays.asList(THREE, FOUR, FIVE, SIX);
    }

    private static String getTrailingStatement(double rateOfReturn) {
        if (rateOfReturn < 1) {
            return FAILURE_STATEMENT;
        }
        return SUCCESS_STATEMENT;
    }
}
