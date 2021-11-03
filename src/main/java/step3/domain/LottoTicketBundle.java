package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketBundle {
    private final List<LottoTicket> lottoTicketBundle = new ArrayList<>();

    public LottoTicketBundle() {
    }

    public void addLottoTicket() {
        lottoTicketBundle.add(new LottoTicket(
            LottoNumberRandomGenerator.generate(LottoNumber.RANGE_MIN_LOTTO_NUMBER, LottoNumber.RANGE_MAX_LOTTO_NUMBER,
                LottoTicket.LOTTO_TICKET_SIZE)));
    }

    public List<List<Integer>> getUnmodifiableListLottoTickets() {
        return forBuyerLottoTicketBundle().stream()
            .collect(Collectors.collectingAndThen(Collectors.toList(),
                Collections::unmodifiableList));
    }

    private List<List<Integer>> forBuyerLottoTicketBundle() {
        return lottoTicketBundle.stream().map(LottoTicket::toLottoNumbers).collect(Collectors.toList());
    }

}
