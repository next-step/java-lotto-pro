package lotto.domain.lotto;

import lotto.prize.Prize;
import lotto.status.ErrorStatus;

import java.util.List;

public class WinnerLotto extends Lotto {

    private final LottoNumber bonusNumber;

    public WinnerLotto(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        super(lottoNumbers);
        validateBonusNumber(lottoNumbers, bonus);
        this.bonusNumber = bonus;
    }

    private void validateBonusNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    @Override
    public Prize matchPrize(Lotto lotto) {
        int count = (int) this.lottoNumbers.stream()
                .filter(lotto::containLottoNumber)
                .count();
        return Prize.prizeOf(count, matchBonusNumber(lotto));
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.containLottoNumber(bonusNumber);
    }
}
