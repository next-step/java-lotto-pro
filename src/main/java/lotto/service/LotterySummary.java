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
            match(details, number);
            bonus(details, number);
        }
    }

    private static void match(Winning details, Number number) {
        if (details.getLottery().contains(number)) {
            count++;
        }
    }

    private static void bonus(Winning details, Number number) {
        if (details.getBonusNumber().equals(number)) {
            bonus = true;
        }
    }

    private static void count() {
        ranks.put(Rank.valueOf(count, bonus), ranks.get(Rank.valueOf(count, bonus)) + 1);
    }
}
