package lotto.domain;

import lotto.enums.LottoRank;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank compareLotto(LottoNumbers winningLottoNumber) {
        // TODO: 해당 부분 변경
        return LottoRank.findLottoRank(this.lottoNumbers.match(winningLottoNumber).size());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
