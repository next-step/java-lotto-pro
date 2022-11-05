package lotto.domain;

import static lotto.domain.LottoWinningRank.findRankByContainCountAndBonusContain;
import static lotto.domain.WinningLottoType.*;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private Lotto basicLotto;
    private LottoNumber bonusNumber;
    public static final int FIVE = 5;
    private WinningLotto() {}

    public static WinningLotto create(Lotto basicLotto, LottoNumber bonusNumber){
        WinningLotto winningLotto = new WinningLotto();

        winningLotto.basicLotto = basicLotto;
        winningLotto.bonusNumber = bonusNumber;

        return winningLotto;
    }

    public int getMatchCountByBasic(Lotto lotto) {
        return lotto.getContainNumberCount(this.basicLotto);
    }

    public boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContain(this.bonusNumber);
    }

    public LottoWinningRank getLottoRank(Lotto lotto) {
        int matchCountByBasic = getMatchCountByBasic(lotto);
        boolean isBonusContain = false;
        if(matchCountByBasic == FIVE){
            isBonusContain = isContainBonusNumber(lotto);
        }

        return findRankByContainCountAndBonusContain(matchCountByBasic, isBonusContain);
    }
}
