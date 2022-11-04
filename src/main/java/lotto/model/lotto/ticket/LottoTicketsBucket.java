package lotto.model.lotto.ticket;

import lotto.model.lotto.enums.LottoNumberMatchCount;
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

    public Map<LottoNumberMatchCount, Integer> calculateNumbersMatchCount(Map<LottoNumberMatchCount, Integer> prizeMoney,
                                                                          WinningNumbers winningNumbers) {
        final Set<LottoNumberMatchCount> keySet = prizeMoney.keySet();
        final List<LottoNumberMatchCount> numbersMatchCandidates = new ArrayList<>(keySet.size());
        numbersMatchCandidates.addAll(keySet);
        final Map<LottoNumberMatchCount, Integer> numbersMatchCount = new HashMap<>(numbersMatchCandidates.size());
        for (LottoNumberMatchCount candidate : numbersMatchCandidates) {
            numbersMatchCount.put(candidate, 0);
        }
        for (LottoTicket lottoTicket : lottoTickets) {
            final int numbersMatch = lottoTicket.numberMatch(winningNumbers);
            if (numbersMatch < 3 || 6 < numbersMatch) {
                continue;
            }
            final LottoNumberMatchCount numberMatchEnum = convertToEnum(numbersMatch);
            incrementCountWhenNumbersMatchIsOneOfTheCandidates(numbersMatchCandidates, numberMatchEnum,
                    numbersMatchCount);
        }
        return numbersMatchCount;
    }

    private LottoNumberMatchCount convertToEnum(int numbersMatch) {
        if (numbersMatch == 3) {
            return LottoNumberMatchCount.THREE;
        }
        if (numbersMatch == 4) {
            return LottoNumberMatchCount.FOUR;
        }
        if (numbersMatch == 5) {
            return LottoNumberMatchCount.FIVE;
        }
        return LottoNumberMatchCount.SIX;
    }

    protected void incrementCountWhenNumbersMatchIsOneOfTheCandidates(List<LottoNumberMatchCount> numbersMatchCandidates,
                                                                      LottoNumberMatchCount numbersMatch,
                                                                      Map<LottoNumberMatchCount, Integer> numbersMatchCount) {
        if (!numbersMatchCandidates.contains(numbersMatch)) {
            return;
        }
        numbersMatchCount.put(numbersMatch, numbersMatchCount.get(numbersMatch) + 1);
    }
}
