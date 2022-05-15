package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class LottoResult {
    private static final int[] PRINTABLE_MATCH_COUNTS = {3, 4, 5, 6};
    private static final String WIN_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOSE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final LottoPayment payment;
    private final LottoTickets tickets;
    private final LottoNumbers winningNumbers;

    public LottoResult(final LottoPayment payment, final LottoTickets tickets, final LottoNumbers winningNumbers) {
        this.payment = payment;
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
    }

    public void printResult() {
        final Map<Prize, Integer> prizeMap = tickets.prizeMap(winningNumbers);
        printPrizes(prizeMap);
        final int income = sumPrizes(prizeMap);
        printReturnOfRatio(income);
    }

    private void printPrizes(final Map<Prize, Integer> prizeMap) {
        for (final int matchCount : PRINTABLE_MATCH_COUNTS) {
            final Prize prize = Prize.findPrizeByMatchCount(matchCount);
            System.out.println(prize.resultMessage(prizeMap.get(prize)));
        }
    }

    private int sumPrizes(final Map<Prize, Integer> prizeMap) {
        int sum = 0;
        for (Entry<Prize, Integer> entry : prizeMap.entrySet()) {
            sum += entry.getKey().getPrize() * entry.getValue();
        }
        return sum;
    }

    private void printReturnOfRatio(final int income) {
        final double returnOfRatio = Double.valueOf(income) / Double.valueOf(payment.getMoney());
        String message = "총 수익률은 " + String.format("%.2f", returnOfRatio) + "입니다.";
        System.out.println(message + (returnOfRatio > 1 ? WIN_MESSAGE : LOSE_MESSAGE));
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "payment=" + payment +
                ", tickets=" + tickets +
                ", winningNumbers=" + winningNumbers +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoResult that = (LottoResult) o;
        return Objects.equals(payment, that.payment) && Objects.equals(tickets, that.tickets)
                && Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment, tickets, winningNumbers);
    }
}
