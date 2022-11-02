package step3.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public WinningLottoRank rank(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers()) {
            matchCount += lotto.getMatchPoint(lottoNumber);
        }
        return WinningLottoRank.getRank(matchCount);
    }
}
