package lotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoPrize compareWinningNumbers(LottoNumbers winningNumbers) {
        long matchCount = lottoNumbers.compare(winningNumbers);
        return LottoPrize.findPrize(matchCount);
    }
}
