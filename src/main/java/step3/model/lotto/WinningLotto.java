package step3.model.lotto;

import step3.model.machine.Result;
import step3.model.value.ErrMsg;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        if(winningLotto.isMatched(bonusNumber)){
            throw new IllegalArgumentException(ErrMsg.BONUS_NUMBER_DUPLICATE);
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


    public Result getMatchResult(Lotto lotto){
        int matchCount = lotto.getMatchCount(winningLotto);
        int bonusMatchCount = 0;
        if(lotto.isMatched(bonusNumber)){
            bonusMatchCount =1;
        }
        return Result.getMatchResult(matchCount, bonusMatchCount);
    }
}
