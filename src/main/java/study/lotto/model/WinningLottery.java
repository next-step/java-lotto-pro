package study.lotto.model;

import java.util.Set;

public class WinningLottery extends Lottery {
    private WinningLottery(Set<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static WinningLottery valueOf(final Set<LottoNumber> lottoNumbers) {
        return new WinningLottery(lottoNumbers);
    }
}
