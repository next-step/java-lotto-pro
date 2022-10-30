package lotto.domain;

import lotto.enums.LottoRank;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank compareLotto(WinningLottoNumbers winningLottoNumber) {
        return LottoRank.findLottoRank(
                lottoNumbers.match(winningLottoNumber.getLottoNumbers()).size(),
                lottoNumbers.isBonusMatch(winningLottoNumber.getBonusNumber())
        );
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
