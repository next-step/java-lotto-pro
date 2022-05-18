package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> buy(Money money) {
        List<LottoTicket> lottoAutoNumbers = new ArrayList<>();
        for (int i = 0; i < money.getMoney() / LOTTO_PRICE; i++) {
            lottoAutoNumbers.add(LottoTicket.makeAuto());
        }
        return lottoAutoNumbers;
    }
}
