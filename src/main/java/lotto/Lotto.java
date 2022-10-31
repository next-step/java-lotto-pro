package lotto;

import java.util.List;

public class Lotto {

    private final LottoNumberBag lottoNumberBag;

    public Lotto(NumberGenerator numberGenerator) {
        lottoNumberBag = new LottoNumberBag(numberGenerator);
    }

    public Lotto(LottoNumberBag lottoNumberBag) {
        this.lottoNumberBag = lottoNumberBag;
    }

    public WinningResult getResult(LottoNumberBag winningNumbers) {
        return WinningResult.getResultByMatchCount(lottoNumberBag.correctCount(winningNumbers));
    }

    public List<Integer> getNumbers() {
        return lottoNumberBag.getNumbers();
    }
}
