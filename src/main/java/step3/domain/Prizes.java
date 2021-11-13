package step3.domain;

import static java.text.MessageFormat.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import step3.enums.Prize;

public class Prizes {
    private static long totalReward;

    private final Map<Prize, Integer> prizes = new HashMap<Prize, Integer>() {{
        put(Prize.FIRST_PLACE, 0);
        put(Prize.SECOND_PLACE, 0);
        put(Prize.THIRD_PLACE, 0);
        put(Prize.FORTH_PLACE, 0);
    }};

    Prizes() {
    }

    public void put(final Prize prize, final int correctCount) {
        this.prizes.computeIfPresent(prize, (ignore, count) -> count + correctCount);
    }

    public String getResults() {
        return new StringJoiner(System.lineSeparator())
            .add(getResultBy(Prize.FORTH_PLACE))
            .add(getResultBy(Prize.THIRD_PLACE))
            .add(getResultBy(Prize.SECOND_PLACE))
            .add(getResultBy(Prize.FIRST_PLACE))
            .toString();
    }

    public String averageYield(final Money money) {
        accumulateRewards();
        return String.format("총 수익률은 %.2f입니다.", (double)totalReward / money.exchangeLottoPurchasableCount());
    }

    private String getResultBy(final Prize prize) {
        final int prizesCount = this.prizes.get(prize);

        return new StringJoiner("- ")
            .add(prize.message())
            .add(format("{0}개", prizesCount))
            .toString();
    }

    private void accumulateRewards() {
        this.prizes
            .forEach((prize, count) -> totalReward += prize.accumulateReward(count).exchangeLottoPurchasableCount());
    }
}
