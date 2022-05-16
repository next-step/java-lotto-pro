package lotto_auto.controller;

import lotto_auto.model.*;
import lotto_auto.view.Output;
import lotto_auto.view.UserInputView;

public class GameController {
    private final Output output = new Output();

    public void run() {
        Money money = getMoney();

        Lottos purchasedLottos = buyLottos(money);
        output.showPurchasedLottos(purchasedLottos);
        Lotto winingLotto = getWinningLotto();

        Figures figures = new Figures(purchasedLottos, winingLotto);
        output.showFigures(figures);

        ProfitRate rate = new ProfitRate(money, figures.getTotalWinning());
        output.showProfitRate(rate);

        UserInputView.closeUserInput();
    }


    private Money getMoney() {
        boolean isValid;
        String userInput;

        do {
            output.showMoneyInputNotice();
            userInput = UserInputView.getUserInput();
            isValid = isValidMoney(userInput);
        } while (!isValid);

        return new Money(userInput);
    }

    private boolean isValidMoney(String money) {
        try {
            new Money(money);
            return true;
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return false;
        }
    }

    private Lotto getWinningLotto() {
        boolean isValid;
        String userinput;
        do {
            output.showWinningLottoNotice();
            userinput = UserInputView.getUserInput();
            isValid = isValidLottoNumber(userinput);
        } while (!isValid);

        return new Lotto(new LottoNumbers(userinput));
    }

    private boolean isValidLottoNumber(String lottoString) {
        try {
            new LottoNumbers(lottoString);
            return true;
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return false;
        }
    }

    private Lottos buyLottos(Money money) {
        output.showPurchaseLottoCountNotice(money.canBuyLottoCount());
        return LottoGenerator.createLottos(money.canBuyLottoCount());
    }

}
