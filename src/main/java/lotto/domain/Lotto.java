package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private WinningRank winningRank;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = LottoNumbers.valueOf(numbers);
    }

    public WinningRank getWinningRank() {
        return winningRank;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void resultLotto(LottoNumbers winningLotto) {
        this.winningRank = WinningRank.result(lottoNumbers.countMatchNumber(winningLotto));
    }

}
