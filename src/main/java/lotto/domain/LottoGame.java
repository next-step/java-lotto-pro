package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final LottoGenerator lottoGenerator;
    private static final int LOTTO_PRICE = 1000;


    public LottoGame() {
        this.lottoGenerator = new LottoGenerator();
    }

    public LottoTickets buy(int purchasePrice) {

        validLottoPrice(purchasePrice);
        int ticketCount = purchasePrice / LOTTO_PRICE;

        // TODO: 로또 생성
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i <ticketCount; i++) {
        }
        return new LottoTickets(lottoTicketList);
    }

    private void validLottoPrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE || (purchasePrice % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("로또 구매에 실패했습니다.");
        }
    }

}
