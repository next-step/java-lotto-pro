package lotto.domain;

import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    static final int TICKET_UNIT_PRICE = 1000;

    private int purchasePrice;

    private double earningRate;

    private LottoResult lottoResult;

    private List<LottoTicket> tickets;

    LottoGame() {
        this.lottoResult = new LottoResult();
    }

    public LottoGame(int purchasePrice, NumberGenerator numberGenerator) {
        this();

        isValidPurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;

        int ticketCount = this.getTicketCount();
        this.tickets = generateAutoTickets(numberGenerator, ticketCount);
    }

    public LottoGame(List<LottoTicket> tickets) {
        this();
        this.purchasePrice = tickets.size() * TICKET_UNIT_PRICE;
        this.tickets = tickets;
    }

    public LottoGame(int purchasePrice, List<LottoTicket> selfTickets, NumberGenerator numberGenerator) {
        this();
        int autoTicketCount = (purchasePrice - (TICKET_UNIT_PRICE * selfTickets.size())) / TICKET_UNIT_PRICE;
        if (autoTicketCount < 0) {
            throw new IllegalArgumentException("Price is not enough to by self ticket");
        }

        this.purchasePrice = purchasePrice;
        this.tickets = new ArrayList<>(selfTickets);
        this.tickets.addAll(generateAutoTickets(numberGenerator, autoTicketCount));
    }

    private List<LottoTicket> generateAutoTickets(NumberGenerator numberGenerator, int autoTicketCount) {
        return IntStream.rangeClosed(1, autoTicketCount)
                .mapToObj(x -> new LottoTicket(numberGenerator))
                .collect(Collectors.toList());
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

    public Map<Rank, Integer> getScore() {
        return lottoResult.getScore();
    }

    public void printGameResult() {
        ResultView.printGameResult(this.getScore(), this.earningRate);
    }

    private void calculateEarningRate() {
        long totalEarning = 0;
        Map<Rank, Integer> scoreMap = lottoResult.getScore();
        for (Map.Entry<Rank, Integer> entry : scoreMap.entrySet()) {
            totalEarning += (long) entry.getKey().getWinningMoney() * entry.getValue();
        }

        if (totalEarning == 0) {
            this.earningRate = 0;
            return ;
        }

        this.earningRate = (double) Math.round((double) totalEarning / this.purchasePrice * 100) / 100;
    }

    private void calculateGameScore(LottoTicket ticket, WinnerTicket winnerTicket) {
        int score = equalNumberCount(ticket, winnerTicket);
        boolean matchBonus = winnerTicket.matchBonus(ticket);
        lottoResult.add(score, matchBonus);
    }

    private static void isValidPurchasePrice(int purchasePrice) {
        if (purchasePrice < TICKET_UNIT_PRICE) {
            throw new IllegalArgumentException("Can't buy ticket. Game will exit.");
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
