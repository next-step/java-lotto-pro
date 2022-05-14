package lotto_auto.controller;

import lotto_auto.exception.IllegalLottoException;
import lotto_auto.exception.IllegalMoneyException;
import lotto_auto.model.*;
import lotto_auto.view.Output;
import lotto_auto.view.UserInputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameController {
    private final Money money;
    private final Output output = new Output();

    public GameController() {
        this.money = getMoney();
    }

    public void run() {
        PurchasedLottoCount purchasedLottoCount = new PurchasedLottoCount(money);
        output.showNotice(Output.purchaseCountGuideFormat, purchasedLottoCount.getCount());

        Lottos lottos = new Lottos();
        for (int i=0; i < purchasedLottoCount.getCount(); i++) {
            lottos.appendLotto(purchaseLotto());
        }

        output.showNotice(lottos.toString());
        Lotto winingLotto = getWinningLotto();

        noticeLottoFigures(lottos, winingLotto);
        UserInputView.closeUserInput();
    }

    private Money getMoney() {
        boolean isValid;
        String userInput;

        do {
            output.showNotice(Output.purchaseStartGuide);
            userInput = UserInputView.getUserInput();
            isValid = isValidMoney(userInput);
        } while (!isValid);

        return new Money(userInput);
    }

    private boolean isValidMoney(String money) {
        try {
            new Money(money);
            return true;
        } catch (IllegalMoneyException e) {
            output.showError(e);
            return false;
        }
    }

    private Lotto purchaseLotto() {
        boolean isValid;
        List<Integer> numberList;

        do {
            Random generatorNumber = new Random();
            IntStream numberStream =  generatorNumber.ints(Lotto.validSize, Lotto.minNumber, Lotto.maxNumber);
            numberList = numberStream.boxed().collect(Collectors.toList());
            isValid = isValidLotto(numberList);
        } while (!isValid);

        return new Lotto(numberList);
    }

    private boolean isValidLotto(List<Integer> list) {
        try {
            new Lotto(list);
            return true;
        } catch (IllegalLottoException e) {
            return false;
        }
    }

    private boolean isValidLotto(String str) {
        try {
            new Lotto(str);
            return true;
        } catch (IllegalLottoException e) {
            output.showError(e);
            return false;
        }
    }

    private Lotto getWinningLotto() {
        boolean isValid;
        String userinput;
        do {
            output.showNotice(Output.winningLottoInputGuide);
            userinput = UserInputView.getUserInput();
            isValid = isValidLotto(userinput);
        } while (!isValid);
        return new Lotto(userinput);
    }

    private void noticeLottoFigures(Lottos lottos, Lotto winning) {
        output.showNotice(Output.lottoFiguresTitle);
        output.showNotice(Output.lottoFiguresDelimiter);

        Figures figures = new Figures(lottos, winning);
        output.showNotice(figures.toString());

        ProfitRate rate = new ProfitRate(money, figures.getProfit());
        output.showNotice(Output.profitRateGuideFormat, rate.printRate());
    }


}
