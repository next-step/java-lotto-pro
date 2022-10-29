package lotto.model.lotto.ticket;

import lotto.constant.numbers.LottoConstant;
import lotto.model.winning.numbers.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 티켓(LottoTicket) 여러 개를 저장하고 관리하는 객체이다.
 */
public class LottoTicketsBucket {
    private final int[] lottoSameNumberCount;
    protected final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        this(new ArrayList<>(howManyTickets));
    }

    public LottoTicketsBucket(List<LottoTicket> lottoTickets) {
        lottoSameNumberCount = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lottoTickets = lottoTickets;
    }

    public LottoTicketsBucket(int[] lottoSameNumberCount) {
        this.lottoSameNumberCount = lottoSameNumberCount;
        lottoTickets = new ArrayList<>();
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public int[] sameNumberCountOfAllLottoTickets(WinningNumbers winningNumbers) {
        for (LottoTicket lottoTicket : lottoTickets) {
            final int count = lottoTicket.sameNumbersCount(winningNumbers);
            ++lottoSameNumberCount[count];
        }
        return lottoSameNumberCount;
    }

    public int sumProfit() {
        return lottoSameNumberCount[3] * LottoConstant.PROFIT_THREE_DIGIT_MATCHES +
                lottoSameNumberCount[4] * LottoConstant.PROFIT_FOUR_DIGIT_MATCHES +
                lottoSameNumberCount[5] * LottoConstant.PROFIT_FIVE_DIGIT_MATCHES +
                lottoSameNumberCount[6] * LottoConstant.PROFIT_SIX_DIGIT_MATCHES;
    }
}
