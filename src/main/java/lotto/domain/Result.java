package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private final List<Prize> prizes = new ArrayList<>();
    private final int numberOfPlayslips;

    public Result(
        final int numberOfPlayslips,
        final int numberOfFirstPrizes,
        final int numberOfSecondPrizes,
        final int numberOfThirdPrizes,
        final int numberOfFourthPrizes
    ) {
        this.numberOfPlayslips = numberOfPlayslips;
        for (int i = 0; i < numberOfFirstPrizes; i++) {
            prizes.add(Prize.FIRST);
        }
        for (int i = 0; i < numberOfSecondPrizes; i++) {
            prizes.add(Prize.SECOND);
        }
        for (int i = 0; i < numberOfThirdPrizes; i++) {
            prizes.add(Prize.THIRD);
        }
        for (int i = 0; i < numberOfFourthPrizes; i++) {
            prizes.add(Prize.FOURTH);
        }
    }

    public int getNumberOfFirstPrizes() {
        return getNumberOfWinningPrizes(Prize.FIRST);
    }

    public int getNumberOfSecondPrizes() {
        return getNumberOfWinningPrizes(Prize.SECOND);
    }

    public int getNumberOfThirdPrizes() {
        return getNumberOfWinningPrizes(Prize.THIRD);
    }

    public int getNumberOfFourthPrizes() {
        return getNumberOfWinningPrizes(Prize.FOURTH);
    }

    private int getNumberOfWinningPrizes(final Prize prize) {
        return Collections.frequency(prizes, prize);
    }

    public double calculateReturnOnInvestment() {
        final long totalPrize = calculateTotalPrizeAmount().getValue();
        final long investedAmount = new Price(numberOfPlayslips).getValue();
        return (double) totalPrize / investedAmount;
    }

    private Price calculateTotalPrizeAmount() {
        return calculateFirstPrizeAmount()
            .add(calculateSecondPrizeAmount())
            .add(calculateThirdPrizeAmount())
            .add(calculateFourthPrizeAmount());
    }

    private Price calculateFirstPrizeAmount() {
        return Prize.FIRST.getAmount().multiply(getNumberOfFirstPrizes());
    }

    private Price calculateSecondPrizeAmount() {
        return Prize.SECOND.getAmount().multiply(getNumberOfSecondPrizes());
    }

    private Price calculateThirdPrizeAmount() {
        return Prize.THIRD.getAmount().multiply(getNumberOfThirdPrizes());
    }

    private Price calculateFourthPrizeAmount() {
        return Prize.FOURTH.getAmount().multiply(getNumberOfFourthPrizes());
    }
}
