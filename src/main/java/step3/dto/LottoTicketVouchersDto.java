package step3.dto;

import java.util.ArrayList;
import java.util.List;

import step3.domain.LottoTicketVoucher;

public class LottoTicketVouchersDto {
    private final List<String> lottoTicketVouchers;

    public LottoTicketVouchersDto(List<String> lottoTicketVouchers) {
        this.lottoTicketVouchers = lottoTicketVouchers;
    }

    public static LottoTicketVouchersDto of(LottoTicketVoucher lottoTicketVoucher) {
        return new LottoTicketVouchersDto(lottoTicketVoucher.toVouchers());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String lottoTicket : lottoTicketVouchers) {
            sb.append(lottoTicket).append("\n");
        }
        return sb.toString();
    }

    public int size() {
        return lottoTicketVouchers.size();
    }
}
