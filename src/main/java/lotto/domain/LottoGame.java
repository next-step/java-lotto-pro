package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.common.ConstValue.LOTTO_PRICE;

public class LottoGame {

    private final LottoResult lottoResult;

    public LottoGame() {
        this.lottoResult = new LottoResult();
    }

    public LottoTickets buy(LottoMoney lottoMoney, List<LottoGenerator> lottoGeneratorList) {

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (LottoGenerator lottoGenerator : lottoGeneratorList) {
            lottoTicketList.add(new LottoTicket(lottoGenerator.generateLottoNumber()));
        }

        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        int autoTicketCount = lottoMoney.minusTicketCount(lottoGeneratorList.size());
        for (int i = 0; i < autoTicketCount; i++) {
            lottoTicketList.add(new LottoTicket(lottoGenerator.generateLottoNumber()));
        }

        return new LottoTickets(lottoTicketList);
    }

    public void makeLottoResult(WinningLottoNumbers winningLottoNumber, LottoTickets lottoTickets) {
        lottoTickets.lottoWinningConfirm(winningLottoNumber, lottoResult);
    }

    public double statisticsPercent(int purchasePrice) {
        return lottoResult.lottoProfitPercent(purchasePrice);
    }

    public LottoResult winningResult() {
        return lottoResult;
    }

}
