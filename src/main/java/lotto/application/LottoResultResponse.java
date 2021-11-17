package lotto.application;

import lotto.domain.Prize;
import lotto.domain.Result;

public class LottoResultResponse {

    private static final String NEWLINE = "\n";

    private final Result result;

    public LottoResultResponse(final Result result) {
        this.result = result;
    }

    public String asString() {
        return "당첨 통계" + NEWLINE
            + "---------" + NEWLINE
            + prizesAsString() + NEWLINE
            + returnOnInvestmentAsString();
    }

    private String prizesAsString() {
        return prizeString(Prize.FIFTH, result.getNumberOfPrizes(Prize.FIFTH)) + NEWLINE
            + prizeString(Prize.FOURTH, result.getNumberOfPrizes(Prize.FOURTH)) + NEWLINE
            + prizeString(Prize.THIRD, result.getNumberOfPrizes(Prize.THIRD)) + NEWLINE
            + secondPrizeString(result.getNumberOfPrizes(Prize.SECOND)) + NEWLINE
            + prizeString(Prize.FIRST, result.getNumberOfPrizes(Prize.FIRST));
    }

    private String prizeString(final Prize prize, final int numberOfPrizes) {
        return prize.getMatchCount()
            + " 개 일치 ("
            + prize.getAmountAsString()
            + " 원)- "
            + numberOfPrizes
            + "개";
    }

    private String secondPrizeString(final int numberOfPrizes) {
        return Prize.SECOND.getMatchCount()
            + " 개 일치, 보너스 볼 일치 ("
            + Prize.SECOND.getAmountAsString()
            + " 원)- "
            + numberOfPrizes
            + "개";
    }

    private String returnOnInvestmentAsString() {
        return "총 수익률은 " + result.calculateReturnOnInvestment() + " 입니다.";
    }
}
