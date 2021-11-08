package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private final List<LottoNumbers> ticket;

    public LottoTicket(final List<LottoNumbers> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket of(final List<LottoNumbers> manualLottoNumbers, final List<LottoNumbers> autoLottoNumbers){
        List<LottoNumbers> lottoNumberList = new ArrayList<>();
        lottoNumberList.addAll(manualLottoNumbers);
        lottoNumberList.addAll(autoLottoNumbers);
        return new LottoTicket(lottoNumberList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket ticket1 = (LottoTicket) o;
        return Objects.equals(ticket, ticket1.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    public List<LottoNumbers> getTicket() {
        return new ArrayList<>(ticket);
    }

}
