package lotto.model.lotto.ticket;

import lotto.model.winning.numbers.WinningNumbers;

import java.util.*;

public class LottoTicketsBucket {
    protected final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        if (!isZeroOrPositive(howManyTickets)) {
            throw new IllegalStateException("구매하려는 로또 개수가 올바르지 않습니다.");
        }
        lottoTickets = new ArrayList<>(howManyTickets);
    }

    private boolean isZeroOrPositive(int howManyTickets) {
        return 0 <= howManyTickets;
    }

    protected LottoTicketsBucket(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public Map<Integer, Integer> calculateNumbersMatchCount(Map<Integer, Integer> prizeMoney,
                                                            WinningNumbers winningNumbers) {
        final Set<Integer> keySet = prizeMoney.keySet();
        final List<Integer> numbersMatchCandidates = new ArrayList<>(keySet.size());
        numbersMatchCandidates.addAll(keySet);
        final Map<Integer, Integer> numbersMatchCount = new HashMap<>(numbersMatchCandidates.size());
        for (Integer candidate : numbersMatchCandidates) {
            numbersMatchCount.put(candidate, 0);
        }
        for (LottoTicket lottoTicket : lottoTickets) {
            final int numbersMatch = lottoTicket.numberMatch(winningNumbers);
            incrementCountWhenNumbersMatchIsOneOfTheCandidates(numbersMatchCandidates, numbersMatch, numbersMatchCount);
        }
        return numbersMatchCount;
    }

    protected void incrementCountWhenNumbersMatchIsOneOfTheCandidates(List<Integer> numbersMatchCandidates,
                                                                      int numbersMatch,
                                                                      Map<Integer, Integer> numbersMatchCount) {
        if (!numbersMatchCandidates.contains(numbersMatch)) {
            return;
        }
        numbersMatchCount.put(numbersMatch, numbersMatchCount.get(numbersMatch) + 1);
    }
}
