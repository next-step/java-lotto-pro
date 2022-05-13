package lotto.domain;

import java.util.List;

public class LottoTickets {
    private List<LottoNumbers> lottoNumbers;

    private LottoTickets(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTickets from(List<LottoNumbers> lottoNumbers) {
        return new LottoTickets(lottoNumbers);
    }

    public int getCount() {
        return this.lottoNumbers.size();
    }

}
