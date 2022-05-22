package lottoauto.util;

public class YieldCalculator {

    private static final int FOURTH = 5000;
    private static final int THIRD = 50000;
    private static final int SECOND = 1500000;
    private static final int FIRST = 2000000000;

    public static double getYield(int price, int one, int two, int three, int four, int five) {
        return (Rank.FIRST.getWinningMoney() * one + Rank.SECOND.getWinningMoney() * two + Rank.THIRD.getWinningMoney() * three +
                Rank.FOURTH.getWinningMoney() * four + Rank.FIFTH.getWinningMoney() * five) / price;
    }
}
