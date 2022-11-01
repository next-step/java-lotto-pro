package lotto.model.lotto.ticket;

import java.util.List;

public class LottoTicket {
    protected final List<LottoNumber> lottoNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
