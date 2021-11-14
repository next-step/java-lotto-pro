package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {

    private final Map<Prize, Integer> prizes = new EnumMap<>(Prize.class);

    public Result(
        final int numberOfFirstPrizes,
        final int numberOfSecondPrizes,
        final int numberOfThirdPrizes,
        final int numberOfFourthPrizes,
        final int numberOfNoPrizes
    ) {
        prizes.put(Prize.FIRST, numberOfFirstPrizes);
        prizes.put(Prize.SECOND, numberOfSecondPrizes);
        prizes.put(Prize.THIRD, numberOfThirdPrizes);
        prizes.put(Prize.FOURTH, numberOfFourthPrizes);
        prizes.put(Prize.NONE, numberOfNoPrizes);
    }

    public int getNumberOfFirstPrizes() {
        return prizes.get(Prize.FIRST);
    }

    public int getNumberOfSecondPrizes() {
        return prizes.get(Prize.SECOND);
    }

    public int getNumberOfThirdPrizes() {
        return prizes.get(Prize.THIRD);
    }

    public int getNumberOfFourthPrizes() {
        return prizes.get(Prize.FOURTH);
    }

    public double calculateReturnOnInvestment() {
        final long totalPrize = calculateTotalPrizeAmount().getValue();
        final int numberOfPlayslips = prizes.values().stream().mapToInt(Integer::intValue).sum();
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
