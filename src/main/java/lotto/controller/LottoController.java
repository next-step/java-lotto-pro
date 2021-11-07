package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.module.AutoGenerator;

import static lotto.view.ConsoleView.*;

public final class LottoController {

    public LottoController() {
    }

    public BoughtLotto buyLotto() {
        try {
            return new BoughtLotto(Integer.parseInt(enterMoney()));
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return buyLotto();
        }
    }

    public LottoTicket generateLottoTicket(BoughtLotto boughtLotto) {
        return LottoTicket.generate(boughtLotto.getBoughtCount(), new AutoGenerator());
    }

    public LottoNumbers enterWinningLottoNumbers() {
        try {
            return LottoNumbers.fromString(enterWinning());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return enterWinningLottoNumbers();
        }
    }

    public Winning enterWinningBonusNumber(LottoNumbers winningNumbers) {
        try {
            return Winning.of(winningNumbers, enterBonusNumber());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return enterWinningBonusNumber(winningNumbers);
        }
    }
}
