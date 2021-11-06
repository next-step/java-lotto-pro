package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoDiscriminator {

    /**
     * 로또복권과 당첨번호를 비교하여 당첨결과를 반환합니다.
     *
     * @param ticketLottery  로또복권
     * @param winningLottery 당첨번호
     */
    public static Rank referee(final WinningLottery winningLottery, final TicketLottery ticketLottery) {
        final int matchCount = getMatchCount(winningLottery, ticketLottery);
        return Rank.valueOf(matchCount);
    }

    public static List<Rank> referee(final WinningLottery winningLottery, final TicketLotteryBundle ticketLotteryBundle) {
        final List<Rank> ranks = new ArrayList<>();
        final List<TicketLottery> ticketLotteries = ticketLotteryBundle.getTicketLotteries();
        for (final TicketLottery ticketLottery : ticketLotteries) {
            ranks.add(referee(winningLottery, ticketLottery));
        }
        return Collections.unmodifiableList(ranks);
    }

    private static int getMatchCount(final WinningLottery winningLottery, final TicketLottery ticketLottery) {
        final Set<LottoNumber> winningLotteryLottoNumbers = winningLottery.getLottoNumbers();
        final Set<LottoNumber> ticketLotteryLottoNumbers = ticketLottery.getLottoNumbers();
        int matchCount = 0;
        for (final LottoNumber ticketLotteryLottoNumber : ticketLotteryLottoNumbers) {
            matchCount = plusIfContains(winningLotteryLottoNumbers, ticketLotteryLottoNumber, matchCount);
        }
        return matchCount;
    }

    private static int plusIfContains(final Set<LottoNumber> winningLotteryLottoNumbers, final LottoNumber ticketLotteryLottoNumber, int matchCount) {
        if (winningLotteryLottoNumbers.contains(ticketLotteryLottoNumber)) {
            matchCount++;
        }
        return matchCount;
    }
}
