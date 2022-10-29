package model;

import enums.Match;

public class Result {
    private final String RESULT_START_MESSAGE = "당첨 통계";
    private final String RESULT_START_DELIMETER = "---------";
    private final String LINE_CHANGE_DELIMETER = "\n";

    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int sixCount;
    int revenueRate = 0;

    public void addResultPerTicket(int matchCount) {
        if (matchCount == 3) {
            threeCount++;
        } else if (matchCount == 4) {
            fourCount++;
        } else if (matchCount == 5) {
            fiveCount++;
        } else if (matchCount == 6) {
            sixCount++;
        }
    }

    public float getRevenueRateRate() {
        revenueRate += threeCount * Match.THREE.getAmount();
        revenueRate += fourCount * Match.FOUR.getAmount();
        revenueRate += fiveCount * Match.FIVE.getAmount();
        revenueRate += sixCount * Match.SIX.getAmount();

        if (getMoney() == 0) return 0;
        return revenueRate / getMoney();
    }

    private int getMoney() {
        return ( this.threeCount * Match.THREE.getAmount() ) + ( this.fiveCount * Match.FOUR.getAmount() ) + ( this.fiveCount * Match.FIVE.getAmount() ) +( this.sixCount * Match.SIX.getAmount() );
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

    private void resultSetting(StringBuffer stringBuffer) {
        stringBuffer.append(Match.THREE.getCount() + "개 일치("+Match.THREE.getAmount() + ")원-" + this.threeCount + "개");
        stringBuffer.append(LINE_CHANGE_DELIMETER);
        stringBuffer.append(Match.FOUR.getCount() + "개 일치("+Match.FOUR.getAmount() + ")원-" + this.fourCount + "개");
        stringBuffer.append(LINE_CHANGE_DELIMETER);
        stringBuffer.append(Match.FIVE.getCount() + "개 일치("+Match.FIVE.getAmount() + ")원-" + this.fiveCount + "개");
        stringBuffer.append(LINE_CHANGE_DELIMETER);
        stringBuffer.append(Match.SIX.getCount() + "개 일치("+Match.SIX.getAmount() + ")원-" + this.sixCount + "개");
        stringBuffer.append(LINE_CHANGE_DELIMETER);
        stringBuffer.append("총 수익률은 " + getRevenueRateRate() + "입니다.(기준이 1이기때문에, 1 이하는 손해임)");
    }
}
