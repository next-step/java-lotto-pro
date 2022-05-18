package lotto_auto.controller;

import lotto_auto.model.*;
import lotto_auto.view.Output;
import lotto_auto.view.UserInputView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameController {
    private final Output output = new Output();

    public void run() {
        Money money = getMoney();

        Lottos purchasedLottos = buyLottos(money);
        output.showPurchasedLottos(purchasedLottos);
        WinningLotto winingLotto = getWinningLotto();

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

    private WinningLotto getWinningLotto() {
        boolean isValid;
        LottoNumbers lottoNumbers = getValidLottoNumber();
        LottoNumber bonusBall;

        do{
            bonusBall = getBonusLottoNumber();
            isValid = isValidWinningLotto(lottoNumbers, bonusBall);
        }while (!isValid);
        return new WinningLotto(new Lotto(lottoNumbers), bonusBall);
    }

    private LottoNumbers getValidLottoNumber() {
        boolean isValid;
        Optional<LottoNumbers> lottoNumbers;

        do {
            output.showWinningLottoNotice();
            String userinput = UserInputView.getUserInput();
            lottoNumbers = getLottoNumbersByUserString(userinput);
            isValid = lottoNumbers.isPresent();
        } while (!isValid);

        return lottoNumbers.get();
    }

    private boolean isValidWinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        try {
            new WinningLotto(new Lotto(lottoNumbers), bonusBall);
            return true;
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return false;
        }
    }

    private LottoNumber getBonusLottoNumber() {
        boolean isValid;

        Optional<LottoNumber> bonusBall;
        do {
            output.showBonusBallInputNotice();
            String userinput = UserInputView.getUserInput();
            bonusBall = getLottoNumberByUserString(userinput);
            isValid = bonusBall.isPresent();
        } while (!isValid);

        return bonusBall.get();
    }

    private Optional<LottoNumbers> getLottoNumbersByUserString(String lottoString) {
        try {
            return Optional.of(getLottoNumberListByStr(lottoString));
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return Optional.empty();
        }
    }

    private Lottos buyLottos(Money money) {
        output.showPurchaseLottoCountNotice(money.canBuyLottoCount());
        return LottoGenerator.createLottos(money.canBuyLottoCount());
    }

    private Optional<LottoNumber> getLottoNumberByUserString(String userinput) {
        try {
            int number = Integer.parseInt(userinput);
            return Optional.of(new LottoNumber(number));
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return Optional.empty();
        }
    }

    private LottoNumbers getLottoNumberListByStr(String lottoStr) {
        try {
            String delimiter = ", ";
            return new LottoNumbers(Arrays.stream(lottoStr.split(delimiter))
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            IllegalArgumentException error = new IllegalArgumentException(LottoNumber.NOT_NUMBER);
            output.showError(error);
            throw error;
        }
    }

}
