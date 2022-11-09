package lotto.model.domain;

import lotto.model.constants.LottoConstants;

public class WinLotto {

    private Lotto winLotto;
    private LottoNumber bonusBall;

    public WinLotto(String winLottoInput, String bonusBallInput) {
        this.winLotto = new Lotto();
        String[] winLottoNumbers = winLottoInput.split(LottoConstants.WIN_LOTTO_DELIMITER);
        for (String winLottoNumber : winLottoNumbers) {
            this.winLotto.addLottoNumber(new LottoNumber(winLottoNumber));
        }
        winLotto.checkLottoNumberCount();
        this.bonusBall = new LottoNumber(bonusBallInput);
    }

    public WinLotto(Lotto lotto, LottoNumber bonusBall) {
        this.winLotto = lotto;
        this.bonusBall = bonusBall;
    }

    public MatchCount compareWithLotto(Lotto userLotto) {
        return new MatchCount(winLotto.compare(userLotto), userLotto.contains(bonusBall));
    }
}
