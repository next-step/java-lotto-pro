package lotto.view;

import static lotto.messages.LottoGameMessages.BENEFIT;
import static lotto.messages.LottoGameMessages.LINE_STRING;
import static lotto.messages.LottoGameMessages.LOSS;
import static lotto.messages.LottoGameMessages.PURCHASED_TICKETS_NUMBER;
import static lotto.messages.LottoGameMessages.RESULT_PRIZED_RATE;
import static lotto.messages.LottoGameMessages.TOTAL_PROFIT_RATE;
import static lotto.messages.LottoGameMessages.TOTAL_WINNING_COUNT;

public class OutputView {


    private static final int BENEFIT_STANDARD = 1;

    public void printPurchasedTicketsCount(int ticketCount) {
        System.out.printf(PURCHASED_TICKETS_NUMBER, ticketCount);
        System.out.println();
    }

    public void printTicketsNumbers(String numberString) {
        System.out.println(numberString);
    }

    public void printTotalString() {
        System.out.println(RESULT_PRIZED_RATE);
        System.out.println(LINE_STRING);
    }

    public void printTotalWinningCount(int countOfMatch, int winningMoney, int winningCount) {
        System.out.printf(TOTAL_WINNING_COUNT,countOfMatch, winningMoney, winningCount);
        System.out.println();
    }

    public void printTotalProfitRate(double profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE,profitRate, profitRate > BENEFIT_STANDARD ? BENEFIT:LOSS);
        System.out.println();
    }
}
