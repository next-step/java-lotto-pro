package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketVoucher {
    private static final String LINE_CHANGE = "\n";
    private final List<LottoTicket> lottoTicketBundle;

    public LottoTicketVoucher(List<LottoTicket> lottoTicketBundle) {
        this.lottoTicketBundle = unmodifiableListLottoTicketsOf(lottoTicketBundle);
    }

    public List<LottoTicket> getLottoTicketBundle() {
        return lottoTicketBundle;
    }

    private List<LottoTicket> unmodifiableListLottoTicketsOf(List<LottoTicket> lottoTicketBundle) {
        return lottoTicketBundle.stream()
            .collect(Collectors.collectingAndThen(Collectors.toList(),
                Collections::unmodifiableList));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTicketBundle) {
            sb.append(lottoTicket.toLottoNumbers().toString()).append(LINE_CHANGE);
        }
        return sb.toString();
    }
}
