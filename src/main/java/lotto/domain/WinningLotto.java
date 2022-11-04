package lotto.domain;

import static lotto.domain.LottoWinningMoney.*;
import static lotto.domain.WinningLottoType.*;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private Map<WinningLottoType, Object> numbers = new HashMap<>();
    public static final int FIVE = 5;
    private WinningLotto() {}

    public static WinningLotto create(Lotto basicLotto, LottoNumber bonusNumber){
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.numbers.put(BASIC, basicLotto);
        winningLotto.numbers.put(BONUS, bonusNumber);

        return winningLotto;
    }

    public int getMatchCountByBasic(Lotto lotto) {
        return lotto.getContainNumberCount((Lotto) numbers.get(BASIC));
    }

    public boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContain((LottoNumber) numbers.get(BONUS));
    }

    public LottoWinningMoney getLottoRank(Lotto lotto) {
        int matchCountByBasic = getMatchCountByBasic(lotto);
        boolean isBonusContain = false;
        if(matchCountByBasic == FIVE){
            isBonusContain = isContainBonusNumber(lotto);
        }

        return findEnumByContainCountAndBonusContain(matchCountByBasic, isBonusContain);
    }
}
