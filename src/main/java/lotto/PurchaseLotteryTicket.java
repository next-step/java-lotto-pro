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

    public int countMatchThree(String[] winningNumber) {
        int matchThreeTicket = 0;
        for (int i = 0 ; i < purchaseLotteryTicket.size() ; i++) {
            matchThreeTicket = countMatchThreeTicket(winningNumber, matchThreeTicket, i);
        }
        return matchThreeTicket;
    }

    private int countMatchThreeTicket(String[] winningNumber, int matchThreeTicket, int i) {
        if(purchaseLotteryTicket.get(i).countMatch(winningNumber) == MATCH_THREE) {
            matchThreeTicket++;
        }
        return matchThreeTicket;
    }

    public int countMatchFour(String[] winningNumber) {
        int matchFourTicket = 0;
        for (int i = 0 ; i < purchaseLotteryTicket.size() ; i++) {
            matchFourTicket = countMatchFourTicket(winningNumber, matchFourTicket, i);
        }
        return matchFourTicket;
    }

    private int countMatchFourTicket(String[] winningNumber, int matchFourTicket, int i) {
        if(purchaseLotteryTicket.get(i).countMatch(winningNumber) == MATCH_FOUR) {
            matchFourTicket++;
        }
        return matchFourTicket;
    }

    public int countMatchFive(String[] winningNumber) {
        int matchFiveTicket = 0;
        for (int i = 0 ; i < purchaseLotteryTicket.size() ; i++) {
            matchFiveTicket = countMatchFiveTicket(winningNumber, matchFiveTicket, i);
        }
        return matchFiveTicket;
    }

    private int countMatchFiveTicket(String[] winningNumber, int matchFiveTicket, int i) {
        if(purchaseLotteryTicket.get(i).countMatch(winningNumber) == MATCH_FIVE) {
            matchFiveTicket++;
        }
        return matchFiveTicket;
    }

    public int countMatchSix(String[] winningNumber) {
        int matchSixTicket = 0;
        for (int i = 0 ; i < purchaseLotteryTicket.size() ; i++) {
            matchSixTicket = countMatchSixTicket(winningNumber, matchSixTicket, i);
        }
        return matchSixTicket;
    }

    private int countMatchSixTicket(String[] winningNumber, int matchSixTicket, int i) {
        if(purchaseLotteryTicket.get(i).countMatch(winningNumber) == MATCH_SIX) {
            matchSixTicket++;
        }
        return matchSixTicket;
    }
}
