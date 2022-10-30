package model;

import enums.Match;

import java.util.Map;

public class Result {
    private static final String RESULT_START_MESSAGE = "당첨 통계";
    private static final String RESULT_START_DELIMETER = "---------";
    private static final String LINE_CHANGE_DELIMETER = "\n";

    private static final String LOTTO_RESULT = "%d개 일치 (%d원)- %d개" + System.lineSeparator();
    public static final int RESULT_DEFAULT_VALUE = 0;
    public static final int RESULT_ADD_VALUE = 1;

    private final Map<Match, Integer> lottoResults;

    public Result(Map<Match, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(RESULT_START_MESSAGE);
        stringBuffer.append(LINE_CHANGE_DELIMETER);
        stringBuffer.append(RESULT_START_DELIMETER);
        stringBuffer.append(LINE_CHANGE_DELIMETER);

        resultSetting(stringBuffer);

        return stringBuffer.toString();
    }

    public int findTotalProfits() {
        int totalProfits = 0;
        for(Map.Entry<Match, Integer> lottoResult: lottoResults.entrySet()) {
            totalProfits += lottoResult.getKey().getAmount() * lottoResult.getValue();
        }
        return totalProfits;
    }

    private void resultSetting(StringBuffer stringBuffer) {
        for(Match match: Match.values()) {
            int lottoResultCount = countLottoResult(match);
            if (!Match.ZERO.equals(match)) {
                stringBuffer.append(String.format(LOTTO_RESULT, match.getCount(), match.getAmount(), lottoResultCount));
            }
        }
    }

    public int countLottoResult(Match match) {
        return lottoResults.getOrDefault(match, RESULT_DEFAULT_VALUE);
    }
}
