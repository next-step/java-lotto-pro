package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketBundle {
    private final List<LottoTicket> lottoTicketBundle = new ArrayList<>();

    public LottoTicketBundle() {
    }

    public void addLottoTicket() {
        lottoTicketBundle.add(new LottoTicket(
            LottoNumberRandomGenerator.generate(LottoNumber.RANGE_MIN_LOTTO_NUMBER, LottoNumber.RANGE_MAX_LOTTO_NUMBER,
                LottoTicket.LOTTO_TICKET_SIZE)));
    }

}
