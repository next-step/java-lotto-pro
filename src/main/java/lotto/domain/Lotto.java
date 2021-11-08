package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private LottoRank lottoRank;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public void compareWinningNumbers(LottoNumbers lottoWinningNumbers) {
        lottoRank = LottoRank.from(getMatchCount(lottoWinningNumbers));
    }

    private int getMatchCount(LottoNumbers lottoWinningNumbers) {
        return Math.toIntExact(lottoNumbers.getLottoNumbers().stream()
                .filter(integer -> lottoWinningNumbers.getLottoNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(integer)))
                .count());
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

}
