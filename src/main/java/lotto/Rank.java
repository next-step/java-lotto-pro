package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NO_MATCH(0, 0);

    private int matchCount;
    private int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }


    public static Rank rank(int matchCount) {
        if(matchCount < FOURTH.matchCount) {
            return NO_MATCH;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    public static int getTotalWinningMoney(PurchaseLotteryTicket purchaseList, WinningNumber winningNumber) {
        return purchaseList.countMatchInAllTicket(winningNumber).getOrDefault(FOURTH, 0) * FOURTH.money
                + purchaseList.countMatchInAllTicket(winningNumber).getOrDefault(THIRD, 0) * THIRD.money
                + purchaseList.countMatchInAllTicket(winningNumber).getOrDefault(SECOND, 0) * SECOND.money
                + purchaseList.countMatchInAllTicket(winningNumber).getOrDefault(FIRST, 0) * FIRST.money;
    }
}
