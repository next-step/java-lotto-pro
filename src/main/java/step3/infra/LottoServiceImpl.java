package step3.infra;

import java.util.List;

import step3.domain.LottoProvider;
import step3.domain.LottoService;
import step3.domain.LottoTicketVoucher;

public class LottoServiceImpl implements LottoService {
    LottoTicketVoucher lottoTicketVoucher;
    int money;

    @Override
    public List<String> buyLotto(int purchaseCost) {
        money = purchaseCost;
        lottoTicketVoucher = LottoProvider.buyLotto(purchaseCost).toLottoTicketVoucher();
        return lottoTicketVoucher.toVouchers();
    }

    @Override
    public String toLottoReport(int[] winNumbers) {
        return lottoTicketVoucher.winningResultToString(winNumbers, money);
    }

}
