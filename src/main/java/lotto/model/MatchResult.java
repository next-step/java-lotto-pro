package lotto.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import lotto.model.enums.Rank;

public class MatchResult {
    private static final String RESULT_HEADER = "당첨 통계" + System.lineSeparator() + "---------";
    private static final String RATE_OF_RETURN_STATEMENT_FORMAT = "총 수익률은 %s입니다.";
    private static final String SUCCESS_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임)";
    private static final String FAILURE_STATEMENT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final Map<Rank, Integer> rankToCount;
    private final RateOfReturn rateOfReturn;

    public MatchResult(Payment payment, Rank... ranks) {
        this(payment, Arrays.asList(ranks));
    }

    public MatchResult(Payment payment, Collection<Rank> ranks) {
        Objects.requireNonNull(payment);
        Objects.requireNonNull(ranks);

        rankToCount = new HashMap<>();
        initialize();

        int prizeMoney = 0;
        for (Rank rank : ranks) {
            rankToCount.merge(rank, 1, Integer::sum);
            prizeMoney += rank.getWinningMoney();
        }
        rateOfReturn = payment.computeRateOfReturn(prizeMoney);
    }

    private void initialize() {
        for (Rank value : Rank.values()) {
            rankToCount.put(value, 0);
        }
    }

    public String toResultString() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(RESULT_HEADER);
        for (Rank rank : Rank.getRanksHavingWinningMoney()) {
            int totalCount = rankToCount.get(rank);
            String matchStatement = rank.computeMatchStatement(totalCount);
            stringJoiner.add(matchStatement);
        }
        stringJoiner.add(computeRateOfReturnStatement());
        return stringJoiner.toString();
    }

    private String computeRateOfReturnStatement() {
        return String.format(RATE_OF_RETURN_STATEMENT_FORMAT, rateOfReturn) + getTrailingStatement();
    }

    private String getTrailingStatement() {
        if (rateOfReturn.isLosingMoney()) {
            return FAILURE_STATEMENT;
        }
        return SUCCESS_STATEMENT;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchResult that = (MatchResult)obj;
        return Objects.equals(rankToCount, that.rankToCount) && Objects.equals(rateOfReturn, that.rateOfReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankToCount, rateOfReturn);
    }
}
