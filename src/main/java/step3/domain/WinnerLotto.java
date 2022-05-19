package step3.domain;

import java.util.List;

public class WinnerLotto {
    private final Lotto winnerLotto;
    private final LottoNumber bounsNumber;

    public WinnerLotto(List<Integer> winnerNumbers, int bonusNumber) {
        this.winnerLotto = LottoFactory.createManualLotto(winnerNumbers);
        this.bounsNumber = LottoNumber.of(bonusNumber);
    }

    public List<LottoNumber> winnerLottoNumbers() {
        return winnerLotto.sortedLottoNumbers();
    }

    public Ranking matchRanking(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.sortedLottoNumbers();
        int hitCount = hitCount(lottoNumbers);
        boolean isMatchBounsNumber = matchBounsNumber(lottoNumbers);
        return Ranking.findRanking(hitCount, isMatchBounsNumber);
    }

    private int hitCount(List<LottoNumber> lottoNumbers) {
        return (int) winnerLottoNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean matchBounsNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(bounsNumber::equals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerLotto that = (WinnerLotto) o;
        return winnerLotto.equals(that.winnerLotto);
    }

    @Override
    public int hashCode() {
        return winnerLotto.hashCode();
    }
}
