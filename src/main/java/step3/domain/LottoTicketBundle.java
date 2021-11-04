package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step3.domain.constance.LottoConstant;

public class LottoTicketBundle {
    private final List<LottoTicket> lottoTicketBundle = new ArrayList<>();

    public LottoTicketBundle() {
    }

    public void addLottoTicket() {
        lottoTicketBundle.add(new LottoTicket(
            LottoNumberRandomGenerator.generate(LottoConstant.RANGE_MIN_LOTTO_NUMBER,
                LottoConstant.RANGE_MAX_LOTTO_NUMBER,
                LottoConstant.LOTTO_TICKET_SIZE)));
    }

    public void addLottoTicket(int... numbers) {
        lottoTicketBundle.add(new LottoTicket(numbers));
    }

    public LottoTicketVoucher toLottoTicketVoucher() {
        return new LottoTicketVoucher(this);
    }

    public List<LottoTicket> getLottoTicketToList() {
        return lottoTicketBundle.stream()
            .collect(Collectors.collectingAndThen(Collectors.toList(),
                Collections::unmodifiableList));
    }
}
