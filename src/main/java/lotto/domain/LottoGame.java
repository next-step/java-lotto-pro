package lotto.domain;

import lotto.ui.ResultView;
import lotto.util.RandomNumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    static final int TICKET_UNIT_PRICE = 1000;

    private int purchasePrice;

    private double earningRate;

    private Map<Integer, Integer> scoreMap;

    private List<LottoTicket> tickets;

    LottoGame() {
        this.scoreMap = new HashMap<>();
        this.scoreMap.put(3, 0);
        this.scoreMap.put(4, 0);
        this.scoreMap.put(5, 0);
        this.scoreMap.put(6, 0);
    }

    public LottoGame(int purchasePrice) {
        this();

        isValidPurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;

        this.tickets = new ArrayList<>();
        int ticketCount = this.getTicketCount();
        for (int i = 1; i <= ticketCount; i++) {
            LottoNumbers numbers = RandomNumberUtils.generateRandomNumber();
            this.tickets.add(new LottoTicket(numbers));
        }
    }

    public LottoGame(List<LottoTicket> tickets) {
        this();
        this.purchasePrice = tickets.size() * TICKET_UNIT_PRICE;
        this.tickets = tickets;
    }

    public double getEarningRate() {
        return this.earningRate;
    }

    public void printTickets() {
        for (LottoTicket ticket : this.tickets) {
            ResultView.printTicket(ticket.toString());
        }
    }

    public void generateGameResult(WinnerTicket winnerTicket) {
        for (LottoTicket ticket : this.tickets) {
            calculateGameScore(ticket, winnerTicket);
        }

        calculateEarningRate();
    }

    public int getTicketCount() {
        return this.purchasePrice / TICKET_UNIT_PRICE;
    }

    public Map<Integer, Integer> getScore() {
        return new HashMap<>(this.scoreMap);
    }

    public void printGameResult() {
        ResultView.printGameResult(this.getScore(), this.earningRate);
    }

    private void calculateEarningRate() {
        long totalEarning = 0;
        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            totalEarning += (long) Score.getPrizeBySameNumberCount(entry.getKey()) * entry.getValue();
        }

        if (totalEarning == 0) {
            this.earningRate = 0;
            return ;
        }

        this.earningRate = (double) Math.round((double) totalEarning / this.purchasePrice * 100) / 100;
    }

    private void calculateGameScore(LottoTicket ticket, WinnerTicket winnerTicket) {
        int score = equalNumberCount(ticket, winnerTicket);
        if (this.scoreMap.containsKey(score)) {
            this.scoreMap.replace(score, this.scoreMap.get(score) + 1);
        }
    }

    private static void isValidPurchasePrice(int purchasePrice) {
        if (purchasePrice < TICKET_UNIT_PRICE) {
            throw new RuntimeException("Can't buy ticket. Game will exit.");
        }
    }

    private int equalNumberCount(LottoTicket ticket, WinnerTicket winnerTicket) {
        int equalNumberCount = 0;
        int[] winnerNumbers = winnerTicket.getNumbersAsArray();

        for (int winnerNumber : winnerNumbers) {
            equalNumberCount = ticket.contains(new LottoNumber(winnerNumber)) ? (equalNumberCount + 1) : equalNumberCount;
        }

        return equalNumberCount;
    }
}
