package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return getLottoNumbers().equals(lotto.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }
}
