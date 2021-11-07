package lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotteryTicket {
    public static final int MATCH_THREE = 3;
    public static final int MATCH_FOUR = 4;
    public static final int MATCH_FIVE = 5;
    public static final int MATCH_SIX = 6;

    private List<LotteryTicket> purchaseLotteryTicket;

    public PurchaseLotteryTicket() {
        purchaseLotteryTicket = new ArrayList<>();
    }

    public void add(LotteryTicket lotteryTicket) {
        this.purchaseLotteryTicket.add(lotteryTicket);
    }

    public LotteryTicket get(int i) {
        return purchaseLotteryTicket.get(i);
    }

    public int countMatchThree(WinningNumber winningNumber) {
        int matchThreeTicket = 0;
        for (LotteryTicket lotteryTicket : purchaseLotteryTicket) {
            matchThreeTicket = getMatchThreeTicket(winningNumber, matchThreeTicket, lotteryTicket);
        }
        return matchThreeTicket;
    }

    private int getMatchThreeTicket(WinningNumber winningNumber, int matchThreeTicket, LotteryTicket lotteryTicket) {
        if (lotteryTicket.countMatch(winningNumber) == MATCH_THREE) {
            matchThreeTicket++;
        }
        return matchThreeTicket;
    }

    public int countMatchFour(WinningNumber winningNumber) {
        int matchFourTicket = 0;
        for (LotteryTicket lotteryTicket : purchaseLotteryTicket) {
            matchFourTicket = getMatchFourTicket(winningNumber, matchFourTicket, lotteryTicket);
        }
        return matchFourTicket;
    }

    private int getMatchFourTicket(WinningNumber winningNumber, int matchFourTicket, LotteryTicket lotteryTicket) {
        if (lotteryTicket.countMatch(winningNumber) == MATCH_FOUR) {
            matchFourTicket++;
        }
        return matchFourTicket;
    }

    public int countMatchFive(WinningNumber winningNumber) {
        int matchFiveTicket = 0;
        for (LotteryTicket lotteryTicket : purchaseLotteryTicket) {
            matchFiveTicket = getMatchFiveTicket(winningNumber, matchFiveTicket, lotteryTicket);
        }
        return matchFiveTicket;
    }

    private int getMatchFiveTicket(WinningNumber winningNumber, int matchFiveTicket, LotteryTicket lotteryTicket) {
        if (lotteryTicket.countMatch(winningNumber) == MATCH_FIVE) {
            matchFiveTicket++;
        }
        return matchFiveTicket;
    }

    public int countMatchSix(WinningNumber winningNumber) {
        int matchSixTicket = 0;
        for (LotteryTicket lotteryTicket : purchaseLotteryTicket) {
            matchSixTicket = getMatchSixTicket(winningNumber, matchSixTicket, lotteryTicket);
        }
        return matchSixTicket;
    }

    private int getMatchSixTicket(WinningNumber winningNumber, int matchSixTicket, LotteryTicket lotteryTicket) {
        if (lotteryTicket.countMatch(winningNumber) == MATCH_SIX) {
            matchSixTicket++;
        }
        return matchSixTicket;
    }
}
