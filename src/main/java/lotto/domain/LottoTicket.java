package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
