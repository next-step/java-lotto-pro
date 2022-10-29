package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 티켓(LottoTicket) 여러 개를 저장하고 관리하는 객체이다.
 */
public class LottoTicketsBucket {
    private static final int SIZE_OF_FULL_CANDIDATE_LIST = 45;
    private final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        lottoTickets = new ArrayList<>(howManyTickets);
        final List<Integer> candidates = intsFromOneToFortyFive();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
        for (int i = 0; i < howManyTickets; ++i) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator));
        }
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(SIZE_OF_FULL_CANDIDATE_LIST);
        for (int i = 1; i <= SIZE_OF_FULL_CANDIDATE_LIST; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }
}
