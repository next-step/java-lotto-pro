package lotto;

import java.util.List;

public class Lotto {

    private final LottoNumberBag lottoNumberBag;

    public Lotto() {
        lottoNumberBag = new LottoNumberBag();
    }

    public Lotto(LottoNumberBag lottoNumberBag) {
        this.lottoNumberBag = lottoNumberBag;
    }

    public WinningResult getResult(List<Integer> winningNumbers) {
        return WinningResult.getResultByMatchCount(lottoNumberBag.correctCount(winningNumbers));
    }
}
