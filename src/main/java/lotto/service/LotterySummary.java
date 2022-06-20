package lotto.service;

import lotto.model.Number;
import lotto.model.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class LotterySummary {
    private static boolean bonus;
    private static int count;
    private static Map<Rank, Integer> ranks;

    private LotterySummary() {
    }

    public static Summary createDetails(Winning details, Lotteries purchase) {
        init();
        for (Lottery lottery : purchase.getLotteries()) {
            clear();
            compare(lottery, details);
            count();
        }
        ranks.remove(Rank.MISS);
        return new Summary(ranks);
    }

    private static void init() {
        ranks = new LinkedHashMap<>();
        for (Rank rank : Rank.reverseValues()) {
            ranks.put(rank, 0);
        }
    }

    private static void clear() {
        bonus = false;
        count = 0;
    }

    private static void compare(Lottery purchase, Winning details) {
        for (Number number : purchase.getNumbers()) {
            containsNumber(details, number);
            equalsBonus(details, number);
        }
    }

    private static void containsNumber(Winning details, Number number) {
        if (details.containsNumber(number)) {
            count++;
        }
    }

    private static void equalsBonus(Winning details, Number number) {
        if (details.equalsBonus(number)) {
            bonus = true;
        }
    }

    private static void count() {
        ranks.put(Rank.valueOf(count, bonus), ranks.get(Rank.valueOf(count, bonus)) + 1);
    }
}
