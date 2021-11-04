package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketVoucher {
    private static final String LINE_CHANGE = "\n";
    private final LottoTicketBundle lottoTicketBundle;

    public LottoTicketVoucher(LottoTicketBundle lottoTicketBundle) {
        this.lottoTicketBundle = lottoTicketBundle;
    }

    public List<String> toVouchers() {
        List<String> lottoTickerNumbers = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTicketBundle.getLottoTicketToList()) {
            lottoTickerNumbers.add(lottoTicket.toLottoNumbers().toString());
        }
        return lottoTickerNumbers;
    }

    public String winningResultToString(int[] winNumbers, int totalPurchasePrice) {
        return new LottoWinningReport(lottoTicketBundle, new LottoTicket(winNumbers), totalPurchasePrice)
            .toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTicketBundle.getLottoTicketToList()) {
            sb.append(lottoTicket.toLottoNumbers().toString()).append(LINE_CHANGE);
        }
        return sb.toString();
    }
}
