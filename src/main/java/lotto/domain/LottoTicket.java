package lotto.domain;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
