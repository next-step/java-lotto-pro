package lotto.model.lotto.ticket;

import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.money.to.buy.MoneyToBuy;
import lotto.model.winning.numbers.WinningNumbers;

import java.util.*;

public class LottoTicketsBucket {
    public static final int PRICE_OF_SINGLE_LOTTO_TICKET = 1000;
    protected final int money;
    private int boughtLottoCount;
    protected final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(MoneyToBuy moneyToBuy) {
        money = moneyToBuy.value();
        if (!isZeroOrPositive(money)) {
            throw new IllegalStateException("구매하려는 로또 개수가 올바르지 않습니다.");
        }
        lottoTickets = new ArrayList<>(affordableTicketCount());
    }

    private boolean isZeroOrPositive(int howManyTickets) {
        return 0 <= howManyTickets;
    }

    protected LottoTicketsBucket(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.money = 1000 * lottoTickets.size();
    }

    public int affordableTicketCount() {
        return money / PRICE_OF_SINGLE_LOTTO_TICKET;
    }

    public boolean canBuyMoreLotto() {
        return boughtLottoCount < affordableTicketCount();
    }

    public void buyOneLotto(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
        ++boughtLottoCount;
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
