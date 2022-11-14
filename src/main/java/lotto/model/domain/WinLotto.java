package lotto.model.domain;

import lotto.model.constants.ErrorMessage;

public class WinLotto {

    private Lotto winLotto;
    private LottoNumber bonusBall;

    public WinLotto(String winLottoInput, String bonusBallInput) {
        this.winLotto = new Lotto(winLottoInput);
        LottoNumber bonusBall = LottoNumber.getLottoNumberByString(bonusBallInput);
        validateBonusBall(winLotto, bonusBall);
        this.bonusBall = bonusBall;
    }

    public WinLotto(Lotto lotto, LottoNumber bonusBall) {
        this.winLotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validateBonusBall(Lotto winLotto, LottoNumber bonusBall) {
        if (winLotto.lottoNumberExist(bonusBall)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_BALL_NUMBER_EXIST);
        }
    }

    public MatchCount compareWithLotto(Lotto userLotto) {
        return new MatchCount(winLotto.compare(userLotto), userLotto.contains(bonusBall));
    }
}
