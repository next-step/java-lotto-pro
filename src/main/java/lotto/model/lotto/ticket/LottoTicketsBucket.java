package lotto.model.lotto.ticket;

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
}
