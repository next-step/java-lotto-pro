package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Result {
    private static final String STR_RESULT_TITLE = "당첨 통계\n";
    private static final String STR_RESULT_SEPARATOR = "---------\n";
    private static final String STR_RESULT_PRIZES = "%s - %s개\n";
    private static final String STR_RESULT_RETURN_RATE = "총 수익률은 %.2f입니다.";
    private static final String STR_RESULT_RETURN_RATE_UNDER_1 = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    
    private Map<Rank, Integer> winningMap;
    private int prizeMoney;

    public Result() {
        this.winningMap = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(r -> {
            winningMap.put(r, 0);
        });
        
        this.prizeMoney = 0;
    }

    public void setResult(int correctCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(correctCount, matchBonus);
        
        if(rank != null) {
            winningMap.put(rank, winningMap.get(rank) + 1);
            this.prizeMoney += rank.getWinningMoney();
        }
    }

    public String toString(int usedMoney) {
        StringBuilder sb = new StringBuilder();
        double returnRate = (double) this.prizeMoney / usedMoney;
        double returnRateStr = Math.floor(returnRate * 100) / 100;

        sb.append(STR_RESULT_TITLE);
        sb.append(STR_RESULT_SEPARATOR);
        
        winningMap.keySet().stream().forEach(r -> {
            String formattedString = String.format(STR_RESULT_PRIZES, r.getPrizeString(), winningMap.get(r));
            sb.append(formattedString);
        });

        sb.append(String.format(STR_RESULT_RETURN_RATE, returnRateStr));
        if (returnRate < 1) {
            sb.append(STR_RESULT_RETURN_RATE_UNDER_1);
        }

        return sb.toString();
    }
}
