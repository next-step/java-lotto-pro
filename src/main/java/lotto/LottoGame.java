package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    final static int TICKET_UNIT_PRICE = 1000;

    private int purchasePrice;

    private double earningRate;

    private Map<Integer, Integer> scoreMap;

    private Map<Integer, Integer> earningMap;

    private LottoNumbers winnerNumbers;

    private List<LottoNumbers> ticketNumbers;

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

        this.ticketNumbers = new ArrayList<>();
        int ticketCount = this.getTicketCount();
        for (int i = 1; i <= ticketCount; i++) {
            this.ticketNumbers.add(new LottoNumbers());
        }

        generateGameResult();
    }

    LottoGame(List<LottoNumbers> ticketNumbers, String winnerNumbers) {
        this();

        this.purchasePrice = ticketNumbers.size() * TICKET_UNIT_PRICE;

        this.ticketNumbers = ticketNumbers;

        this.winnerNumbers = new LottoNumbers(winnerNumbers);
        generateGameResult();
    }

    public double getEarningRate() {
        return this.earningRate;
    }

    private void generateGameResult() {
        for (LottoNumbers ticket : this.ticketNumbers) {
            setGameScore(ticket);
        }

        setEarningRate();
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

    private void setGameScore(LottoNumbers ticket) {
        int score = equalNumberCount(ticket);
        if (this.scoreMap.containsKey(score)) {
            this.scoreMap.replace(score, this.scoreMap.get(score) + 1);
        }
    }

    public int getTicketCount() {
        return this.purchasePrice / TICKET_UNIT_PRICE;
    }

    public Map<Integer, Integer> getScore() {
        return new HashMap<>(this.scoreMap);
    }

    private static void isValidPurchasePrice(int purchasePrice) {
        if (purchasePrice < TICKET_UNIT_PRICE) {
            throw new RuntimeException("Can't buy ticket. Game will exit.");
        }
    }

    public void setWinnerNumbers(String numbersWithComma) {
        this.winnerNumbers = new LottoNumbers(numbersWithComma);
    }

    private int equalNumberCount(LottoNumbers ticketNumbers) {
        int equalNumberCount = 0;
        int[] winnerNumbers = this.winnerNumbers.getNumbersAsArray();

        for (int winnerNumber : winnerNumbers) {
            equalNumberCount = ticketNumbers.contains(winnerNumber) ? (equalNumberCount + 1) : equalNumberCount;
        }

        return equalNumberCount;
    }
}
