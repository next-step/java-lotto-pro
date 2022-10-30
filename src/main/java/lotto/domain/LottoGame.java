package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.ConstValue.LOTTO_PRICE;

public class LottoGame {

    private final LottoResult lottoResult;

    public LottoGame() {
        this.lottoResult = new LottoResult();
    }

    public LottoTickets buy(int purchasePrice) {
        validLottoPrice(purchasePrice);
        int ticketCount = purchasePrice / LOTTO_PRICE;

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTicketList.add(new LottoTicket(lottoGenerator.generateLottoNumber()));
        }
        return new LottoTickets(lottoTicketList);
    }

    private void validLottoPrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE || (purchasePrice % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("로또 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public void makeLottoResult(LottoNumbers winningLottoNumber, LottoTickets lottoTickets) {
        lottoTickets.matchLottoResult(winningLottoNumber, lottoResult);
    }

    public double statisticsPercent(int purchasePrice) {
        return lottoResult.lottoProfitPercent(purchasePrice);
    }

    public LottoResult winningResult() {
        return lottoResult;
    }

}
