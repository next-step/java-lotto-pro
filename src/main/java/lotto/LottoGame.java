package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    final static int TICKET_UNIT_PRICE = 1000;

    private int purchasePrice;

    private double earningRate;

    Map<Integer, Integer> scoreMap;

    private LottoNumbers winnerNumbers;

    private List<LottoNumbers> ticketNumbers;

    LottoGame() {
        this.scoreMap = new HashMap<>();
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

    private void generateGameResult() {
        this.scoreMap = new HashMap<>();
        for (LottoNumbers ticket : this.ticketNumbers) {
            setGameScore(ticket);
        }
    }

    private void setGameScore(LottoNumbers ticket) {
        int score = equalNumberCount(ticket);
        if (this.scoreMap.containsKey(score)) {
            this.scoreMap.replace(score, this.scoreMap.get(score) + 1);
            return ;
        }

        this.scoreMap.put(score, 1);
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
