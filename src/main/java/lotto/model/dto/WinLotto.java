package lotto.model.dto;

import lotto.model.constants.LottoConstants;
import lotto.model.vo.Lotto;
import lotto.model.vo.LottoNumber;

public class WinLotto {

    private Lotto winLotto;

    public WinLotto(String input) {
        this.winLotto = new Lotto();
        String[] winLottoNumbers = input.split(LottoConstants.WIN_LOTTO_DELIMITER);
        for (String winLottoNumber : winLottoNumbers) {
            this.winLotto.addLottoNumber(new LottoNumber(winLottoNumber));
        }
    }

    public WinLotto(Lotto lotto) {
        this.winLotto = lotto;
    }

    public int compareWithLotto(Lotto userLotto) {
        return winLotto.compare(userLotto);
    }
}
