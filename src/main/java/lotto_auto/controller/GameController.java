package lotto_auto.controller;

import lotto_auto.model.*;
import lotto_auto.view.Output;
import lotto_auto.view.UserInputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            isValid = isValidLottoNumbers(userinput);
        } while (!isValid);
        List<LottoNumber> numbers = getLottoNumberListFromStr(userinput);
        return new Lotto(new LottoNumbers(numbers));
    }

    private boolean isValidLottoNumbers(String lottoString) {
        try {
            List<LottoNumber> numbers = getLottoNumberListFromStr(lottoString);
            new LottoNumbers(numbers);
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

    private List<LottoNumber> getLottoNumberListFromStr(String lottoStr) {
        try {
            String delimiter = ", ";
            return Arrays.stream(lottoStr.split(delimiter))
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            IllegalArgumentException error = new IllegalArgumentException(LottoNumber.NOT_NUMBER);
            output.showError(error);
            throw error;
        }
    }

}
