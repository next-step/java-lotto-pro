package step3.domain;

import java.util.List;

import step3.dto.LottoTicketVouchersDto;

public interface LottoService {
    public LottoTicketVouchersDto buyLotto(int purchaseCost);

    String toLottoReport(int[] winNumbers);
}
