package lotto;

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

    private Map<Integer, Integer> earningMap;

    private WinnerTicket winnerTicket;

    private List<LottoTicket> tickets;

    LottoGame() {
        this.scoreMap = new HashMap<>();
        this.scoreMap.put(3, 0);
        this.scoreMap.put(4, 0);
        this.scoreMap.put(5, 0);
        this.scoreMap.put(6, 0);

        this.earningMap = new HashMap<>();
        this.earningMap.put(3, 5000);
        this.earningMap.put(4, 50000);
        this.earningMap.put(5, 1500000);
        this.earningMap.put(6, 2000000000);
    }

    LottoGame(int purchasePrice) {
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

    LottoGame(List<LottoTicket> tickets, WinnerTicket winnerTicket) {
        this();

        this.purchasePrice = tickets.size() * TICKET_UNIT_PRICE;

        this.tickets = tickets;

        this.winnerTicket = winnerTicket;
        generateGameResult();
    }

    public double getEarningRate() {
        return this.earningRate;
    }

    public void printTickets() {
        for (LottoTicket ticket : this.tickets) {
            ResultView.printTicket(ticket.toString());
        }
    }

    public void generateGameResult() {
        for (LottoTicket ticket : this.tickets) {
            setGameScore(ticket);
        }

        setEarningRate();
    }

    public int getTicketCount() {
        return this.purchasePrice / TICKET_UNIT_PRICE;
    }

    public Map<Integer, Integer> getScore() {
        return new HashMap<>(this.scoreMap);
    }


    public void initWinnerTicket(String winnerNumbers) {
        this.winnerTicket = new WinnerTicket(winnerNumbers);
    }

    public void printGameResult() {
        ResultView.printGameResult(this.getScore(), this.earningRate);
    }

    private void setEarningRate() {
        long totalEarning = 0;
        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            totalEarning += (long) this.earningMap.get(entry.getKey()) * entry.getValue();
        }

        if (totalEarning == 0) {
            this.earningRate = 0;
            return ;
        }

        this.earningRate = (double) Math.round((double) totalEarning / this.purchasePrice * 100) / 100;
    }

    private void setGameScore(LottoTicket ticket) {
        int score = equalNumberCount(ticket);
        if (this.scoreMap.containsKey(score)) {
            this.scoreMap.replace(score, this.scoreMap.get(score) + 1);
        }
    }

    private static void isValidPurchasePrice(int purchasePrice) {
        if (purchasePrice < TICKET_UNIT_PRICE) {
            throw new RuntimeException("Can't buy ticket. Game will exit.");
        }
    }

    private int equalNumberCount(LottoTicket ticket) {
        int equalNumberCount = 0;
        int[] winnerNumbers = this.winnerTicket.getNumbersAsArray();

        for (int winnerNumber : winnerNumbers) {
            equalNumberCount = ticket.contains(new LottoNumber(winnerNumber)) ? (equalNumberCount + 1) : equalNumberCount;
        }

        return equalNumberCount;
    }
}
