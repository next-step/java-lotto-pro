package lotto;

import java.util.Collections;
import java.util.List;

public class LotteryTicket {
    private final List<Integer> lottoTicket;

    public LotteryTicket(List<Integer> autoPickedLottoNumber) {
        Collections.sort(autoPickedLottoNumber);
        this.lottoTicket = autoPickedLottoNumber;
    }

    public int size() {
        return lottoTicket.size();
    }
}
