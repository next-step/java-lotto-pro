package lotto.domain;

import lotto.LottoConstants;
import lotto.ui.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private LottoTickets autoTickets = new LottoTickets();

    private LottoTickets selfTickets = new LottoTickets();

    private double earningRate;

    private final LottoResult lottoResult;

    LottoGame() {
        this.lottoResult = new LottoResult();
    }

    public LottoGame(int purchasePrice, NumberGenerator numberGenerator) {
        this();

        isValidPurchasePrice(purchasePrice);

        int ticketCount = purchasePrice / LottoConstants.TICKET_UNIT_PRICE;
        this.autoTickets = new LottoTickets(generateAutoTickets(numberGenerator, ticketCount));
    }

    public LottoGame(List<LottoTicket> tickets) {
        this();
        this.autoTickets = new LottoTickets(tickets);
    }

    public LottoGame(int purchasePrice, List<LottoTicket> selfTickets, NumberGenerator numberGenerator) {
        this();
        int selfTicketTotalPrice = LottoConstants.TICKET_UNIT_PRICE * selfTickets.size();
        int remainingAutoTicketCount = (purchasePrice - selfTicketTotalPrice) / LottoConstants.TICKET_UNIT_PRICE;
        final int MINIMUM_AUTO_TICKET_COUNT = 0;
        if (remainingAutoTicketCount < MINIMUM_AUTO_TICKET_COUNT) {
            throw new IllegalArgumentException("Price is not enough to by self ticket");
        }

        this.selfTickets = new LottoTickets(selfTickets);
        this.autoTickets = new LottoTickets(generateAutoTickets(numberGenerator, remainingAutoTicketCount));
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
        LottoTickets tickets = generateAllTickets();
        for (LottoTicket ticket : tickets.getTicketList()) {
            ResultView.printTicket(ticket.toString());
        }
    }

    public int getAutoTicketCount() {
        return this.autoTickets.count();
    }

    public int getSelfTicketCount() {
        return this.selfTickets.count();
    }

    public void generateGameResult(WinnerTicket winnerTicket, int purchasePrice) {
        LottoTickets tickets = generateAllTickets();
        for (LottoTicket ticket : tickets.getTicketList()) {
            calculateGameScore(ticket, winnerTicket);
        }

        calculateEarningRate(purchasePrice);
    }

    public Map<Rank, Integer> getScore() {
        return lottoResult.getScore();
    }

    public void printGameResult() {
        ResultView.printGameResult(this.getScore(), this.earningRate);
    }

    private void calculateEarningRate(int purchasePrice) {
        long totalEarning = 0;
        Map<Rank, Integer> scoreMap = lottoResult.getScore();
        for (Map.Entry<Rank, Integer> entry : scoreMap.entrySet()) {
            totalEarning += (long) entry.getKey().getWinningMoney() * entry.getValue();
        }

        if (totalEarning == 0) {
            this.earningRate = 0;
            return ;
        }

        final int ROUND_UP_TO_TWO_DECIMAL = 100;
        this.earningRate = (double) Math.round((double) totalEarning / purchasePrice
                * ROUND_UP_TO_TWO_DECIMAL) / ROUND_UP_TO_TWO_DECIMAL;
    }

    private void calculateGameScore(LottoTicket ticket, WinnerTicket winnerTicket) {
        int score = equalNumberCount(ticket, winnerTicket);
        boolean matchBonus = winnerTicket.matchBonus(ticket);
        lottoResult.add(score, matchBonus);
    }

    private static void isValidPurchasePrice(int purchasePrice) {
        if (purchasePrice < LottoConstants.TICKET_UNIT_PRICE) {
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

    private LottoTickets generateAllTickets() {
        return new LottoTickets(this.autoTickets, this.selfTickets);
    }
}
