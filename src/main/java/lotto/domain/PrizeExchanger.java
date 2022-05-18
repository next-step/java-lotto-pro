package lotto.domain;

public class PrizeExchanger {
    private static final PrizeExchanger INSTANCE = new PrizeExchanger();
    private static final Prize[] RANK = {Prize.FOURTH_PLACE, Prize.THIRD_PLACE, Prize.SECOND_PLACE, Prize.FIRST_PLACE};
    private static final int ZERO = 0;

    private PrizeExchanger() {
    }

    public static PrizeExchanger getInstance() {
        return INSTANCE;
    }

    public long exchange(final Winners winners) {
        long totalPrize = ZERO;
        for (Prize rank : RANK) {
            long count = winners.countEachPrize(rank);
            rank.printMatch(count);
            totalPrize += rank.calculatePrize(count);
        }
        return totalPrize;
    }
}
