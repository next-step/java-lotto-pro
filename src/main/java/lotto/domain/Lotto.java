package lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoPrize compareWinningNumbers(WinningLottoNumbers winningNumbers) {
        long matchCount = lottoNumbers.compare(winningNumbers);
        boolean matchBonus = lottoNumbers.isContainBonusNumber(winningNumbers);
        return LottoPrize.findPrize(matchCount, matchBonus);
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }
}
