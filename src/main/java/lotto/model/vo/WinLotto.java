package lotto.model.vo;

import lotto.model.constants.LottoConstants;

public class WinLotto {

    private Lotto winLotto;

    public WinLotto(String input) {
        this.winLotto = new Lotto();
        String[] winLottoNumbers = input.split(LottoConstants.WIN_LOTTO_DELIMITER);
        for (String winLottoNumber : winLottoNumbers) {
            this.winLotto.addLottoNumber(new LottoNumber(winLottoNumber));
        }
        winLotto.checkLottoNumberCount();
    }

    public WinLotto(Lotto lotto) {
        this.winLotto = lotto;
    }

    public int compareWithLotto(Lotto userLotto) {
        return winLotto.compare(userLotto);
    }
}
