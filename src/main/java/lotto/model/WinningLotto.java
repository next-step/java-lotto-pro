package lotto.model;

import lotto.view.GameMessage;

public class WinningLotto {

    private final LottoPaper winningLottoPaper;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoPaper winningLottoPaper, LottoNumber bonusLottoNumber) {

        if (winningLottoPaper.isContainsLottoNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_BONUS_NUMBER_INPUT));
        }

        this.winningLottoPaper = winningLottoPaper;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoPaper getWinningLottoPaper() {
        return winningLottoPaper;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }

}
