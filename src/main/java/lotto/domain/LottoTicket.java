package lotto.domain;

import lotto.enums.LottoRank;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;
    private LottoRank lottoRankResult;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void lottoWinningConfirm(WinningLottoNumbers winningLottoNumber) {
        lottoRankResult = LottoRank.findLottoRank(getMatchCount(winningLottoNumber), isBonusMatch(winningLottoNumber));
    }

    private int getMatchCount(WinningLottoNumbers winningLottoNumber) {
        return lottoNumbers.match(winningLottoNumber.getLottoNumbers()).size();
    }

    private boolean isBonusMatch(WinningLottoNumbers winningLottoNumber) {
        return lottoNumbers.isBonusMatch(winningLottoNumber.getBonusNumber());
    }

    public LottoRank getLottoRankResult() {
        return lottoRankResult;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
