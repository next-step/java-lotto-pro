package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public LottoRank checkResult(Lotto lotto) {
        return LottoRank.getRank(this.getMatchCount(lotto));
    }

}
