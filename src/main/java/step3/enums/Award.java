package step3.enums;

import java.util.HashMap;
import java.util.Map;

public enum Award {
    BASE(0, 1000),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    BONUS(2, 30000000);

    private final int count;
    private final int amount;

    Award(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public static Map<Integer, Integer> initRank() {
        Map<Integer, Integer> rank = new HashMap<>();

        rank.put(Award.THREE.getCount(), 0);
        rank.put(Award.FOUR.getCount(), 0);
        rank.put(Award.FIVE.getCount(), 0);
        rank.put(Award.FIVE.getCount() + Award.BONUS.getCount(), 0);
        rank.put(Award.SIX.getCount(), 0);

        return rank;
    }

    public static int calculateLottoCount(int money) {
        return money / Award.BASE.amount;
    }

    public static double statistic(Map<Integer, Integer> statistics) {

        double sum = statistics.get(Award.THREE.getCount()) * Award.THREE.amount;
        sum += statistics.get(Award.FOUR.getCount()) * Award.FOUR.amount;
        sum += statistics.get(Award.FIVE.getCount()) * Award.FIVE.amount;
        sum += statistics.get(Award.FIVE.getCount() + Award.BONUS.getCount()) * Award.BONUS.amount;
        sum += statistics.get(Award.SIX.getCount()) * Award.SIX.amount;
        return Math.floor(sum / Award.BASE.amount * 100) / 100;
    }

}
