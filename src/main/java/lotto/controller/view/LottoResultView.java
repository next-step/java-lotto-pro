package lotto.controller.view;

import java.util.Map;
import java.util.StringJoiner;

import lotto.model.dto.MatchResult;
import lotto.model.dto.enums.MatchCount;

public class LottoResultView {
    private static final String HEADER = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String MATCH_STATEMENT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String RATE_OF_RETURN_STATEMENT_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String SUCCESS_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임)";
    private static final String FAILURE_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public final String resultAsString;

    private final Map<MatchCount, Integer> matchCountToCount;
    private final double rateOfReturn;

    public LottoResultView(MatchResult matchResult) {
        this.matchCountToCount = matchResult.getMatchCountToCount();
        this.rateOfReturn = matchResult.getRateOfReturn();
        this.resultAsString = getResultAsString();
    }

    private String getResultAsString() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(HEADER);
        for (int i = 3; i <= 6; i++) {
            MatchCount matchCount = MatchCount.ofValue(i);
            stringJoiner.add(
                String.format(MATCH_STATEMENT_FORMAT, i, matchCount.getPrizeMoney(), matchCountToCount.get(matchCount))
            );
        }
        stringJoiner.add(String.format(RATE_OF_RETURN_STATEMENT_FORMAT, rateOfReturn));
        return stringJoiner + getTrailingStatement();
    }

    private String getTrailingStatement() {
        if (rateOfReturn < 1) {
            return FAILURE_STATEMENT;
        }
        return SUCCESS_STATEMENT;
    }
}
