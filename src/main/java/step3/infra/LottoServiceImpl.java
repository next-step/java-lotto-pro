package step3.infra;

import java.util.List;

import step3.domain.LottoProvider;
import step3.domain.LottoService;
import step3.domain.LottoTicketVoucher;
import step3.dto.LottoTicketVouchersDto;

public class LottoServiceImpl implements LottoService {
    LottoTicketVoucher lottoTicketVoucher;
    int money;

    @Override
    public LottoTicketVouchersDto buyLotto(int purchaseCost) {
        money = purchaseCost;
        lottoTicketVoucher = LottoProvider.buyLotto(purchaseCost);
        return LottoTicketVouchersDto.of(lottoTicketVoucher);
    }

    @Override
    public String toLottoReport(int[] winNumbers) {
        return lottoTicketVoucher.winningResultToString(winNumbers, money);
    }

}
