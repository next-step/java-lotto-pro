package step3.enums;

import static java.text.MessageFormat.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import step3.domain.Money;

public class Prizes {
    private static int totalReward;

    private final List<Prize> prizes = new ArrayList<>();

    public Prizes() {
    }

    public void add(final Prize prize) {
        this.prizes.add(prize);
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
        return String.format("총 수익률은 %.2f입니다.", (double)totalReward / money.changeUnit());
    }

    private String getResultBy(final Prize targetPrize) {
        final List<Prize> prizes = collect(targetPrize);

        accumulateRewards(prizes);

        return new StringJoiner("- ")
            .add(targetPrize.message())
            .add(format("{0}개", prizes.size()))
            .toString();
    }

    private void accumulateRewards(final List<Prize> prizes) {
        for (final Prize prize : prizes) {
            totalReward += prize.getReward().changeUnit();
        }
    }

    private List<Prize> collect(final Prize targetPrize) {
        final List<Prize> collectPrize = new ArrayList<>();

        for (final Prize sourcePrize : this.prizes) {
            collectIfEqual(targetPrize, sourcePrize, collectPrize);
        }

        return collectPrize;
    }

    private void collectIfEqual(final Prize targetPrize, final Prize sourcePrize, final List<Prize> collectPrize) {
        if (!Objects.equals(targetPrize, sourcePrize)) {
            return;
        }

        collectPrize.add(sourcePrize);
    }
}
