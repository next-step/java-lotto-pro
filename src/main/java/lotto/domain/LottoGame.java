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

}
