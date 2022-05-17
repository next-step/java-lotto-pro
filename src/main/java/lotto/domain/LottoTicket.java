package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(List<Integer> lottoNumberList) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : lottoNumberList) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
