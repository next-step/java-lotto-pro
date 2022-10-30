package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.enums.Rank;

public class Lotto {

    private final LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public Rank match(WinningLotto winningLotto) {
        List<Integer> copy = new ArrayList<>(lottoNumber.getLottoNumber());
        copy.retainAll(winningLotto.getWinningNumber().getLottoNumber());
        return Rank.rank(copy.size(), lottoNumber.hasBonusNumber(winningLotto.getBonusNumber()));
    }

}
