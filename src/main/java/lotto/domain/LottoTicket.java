package lotto.domain;

import lotto.enums.LottoRank;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank compareLotto(LottoNumbers winningLottoNumber) {
        return LottoRank.findLottoRank(this.lottoNumbers.match(winningLottoNumber).size());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
