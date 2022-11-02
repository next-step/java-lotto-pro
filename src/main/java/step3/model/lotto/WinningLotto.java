package step3.model.lotto;

import java.util.HashSet;
import java.util.List;
import step3.model.machine.Match;
import step3.model.machine.Result;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        verifyLottoNumbers(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void verifyLottoNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if(lottoNumbers.size() != Rule.LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException(ErrMsg.WRONG_LENGTH);
        }
        if(lottoNumbers.size() != new HashSet<>(lottoNumbers).size()){
            throw new IllegalArgumentException(ErrMsg.DUPLICATED_INPUT);
        }
        if(lottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrMsg.BONUS_NUMBER_DUPLICATE);
        }
    }

    public Result getMatchResult(Lotto lotto){
        int matchCount = (int)lottoNumbers.stream().filter(lotto::isMatched).count();
        int bonusMatchCount = 0;
        if(lotto.isMatched(bonusNumber)){
            bonusMatchCount =1;
        }
        return Result.getMatchResult(new Match(matchCount, bonusMatchCount));
    }
}
