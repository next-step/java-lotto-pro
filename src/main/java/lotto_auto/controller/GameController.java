package lotto_auto.controller;

import lotto_auto.model.*;
import lotto_auto.view.Output;
import lotto_auto.view.UserInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameController {
    UserInputView userInputView = new UserInputView();
    public void run() {

        Money money = getMoney();
        PurchaseInfo purchaseInfo = getPurchasedInfo(money);

        Lottos manualLottos = getManualLottos(purchaseInfo.getManualLottoCount());
        Lottos purchasedLottos = LottoGenerator.buyLottos(purchaseInfo, manualLottos);
        Output.showPurchasedLottos(purchasedLottos);

        WinningLotto winingLotto = getWinningLotto();

        Figures figures = purchasedLottos.matchedLottos(winingLotto);
        Output.showFigures(figures);

        ProfitRate rate = new ProfitRate(money, figures.getTotalWinning());
        Output.showProfitRate(rate);

        userInputView.closeUserInput();
    }

    private Money getMoney() {
        String userInput;
        Optional<Money> money;

        do {
            userInput = userInputView.getUserInputMoney();
            money = getValidMoney(userInput);
        } while (!money.isPresent());

        return money.get();
    }

    private Optional<Money> getValidMoney(String userinput) {
        try {
            return Optional.of(new Money(userinput));
        } catch (IllegalArgumentException e) {
            Output.showError(e);
            return Optional.empty();
        }
    }

    private LottoCount getManualLottoCount() {
        String userInput;
        Optional<LottoCount> lottoCount;

        do {
            userInput = userInputView.getManualLottoCountUserInput();
            lottoCount = getValidLottoCount(userInput);
        } while (!lottoCount.isPresent());
        return lottoCount.get();
    }

    private Optional<LottoCount> getValidLottoCount(String userInput) {
        try {
            return Optional.of(new LottoCount(userInput));
        } catch (IllegalArgumentException e) {
            Output.showError(e);
            return Optional.empty();
        }
    }

    private Optional<LottoNumbers> getLottoNumbersByUserString(String lottoString) {
        if (lottoString.isEmpty()) {
            return Optional.empty();
        }

        try {
            return Optional.of(getLottoNumberListByStr(lottoString));
        } catch (IllegalArgumentException e) {
            Output.showError(e);
            return Optional.empty();
        }
    }

    private LottoNumbers getLottoNumberListByStr(String lottoStr) {
        try {
            String delimiter = ",";
            String blank = " ";
            return new LottoNumbers(Arrays.stream(lottoStr.replaceAll(blank , "").split(delimiter))
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toSet()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoNumber.NOT_NUMBER);
        }
    }

    private PurchaseInfo getPurchasedInfo(Money money) {
        boolean isValid;
        LottoCount lottoCount;

        do {
            lottoCount = getManualLottoCount();
            isValid = isAvailableForPurchase(money, lottoCount);
        } while (!isValid);

        return new PurchaseInfo(money, lottoCount);
    }

    private boolean isAvailableForPurchase(Money money, LottoCount manualLottoCount) {
        try {
            new PurchaseInfo(money, manualLottoCount);
            return true;
        } catch (Exception e) {
            Output.showError(e);
            return false;
        }
    }

    private Lottos getManualLottos(int manualLottoCount) {
        Output.showPurchaseManualLottoNotice();

        List<LottoNumbers> manualLottoNumbersList = new ArrayList<>();
        for (int i=0; i < manualLottoCount; i++) {
            manualLottoNumbersList.add(getValidLottoNumbers());
        }

        return new Lottos(manualLottoNumbersList.stream().map(Lotto::new).collect(Collectors.toList()));
    }

    private LottoNumbers getValidLottoNumbers() {
        boolean isValid;
        Optional<LottoNumbers> lottoNumbers;

        do {
            String userinput = userInputView.getUserInput();
            lottoNumbers = getLottoNumbersByUserString(userinput);
            isValid = lottoNumbers.isPresent();
        } while (!isValid);

        return lottoNumbers.get();
    }

    public WinningLotto getWinningLotto() {
        boolean isValid;
        Output.showWinningLottoNotice();
        LottoNumbers lottoNumbers = getValidLottoNumbers();
        LottoNumber bonusBall;

        do{
            bonusBall = getBonusLottoNumber();
            isValid = isValidWinningLotto(lottoNumbers, bonusBall);
        }while (!isValid);
        return new WinningLotto(new Lotto(lottoNumbers), bonusBall);
    }

    private LottoNumber getBonusLottoNumber() {
        boolean isValid;

        Optional<LottoNumber> bonusBall;
        do {
            Output.showBonusBallInputNotice();
            String userinput = userInputView.getUserInput();
            bonusBall = getLottoNumberByUserString(userinput);
            isValid = bonusBall.isPresent();
        } while (!isValid);

        return bonusBall.get();
    }

    private boolean isValidWinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        try {
            new WinningLotto(new Lotto(lottoNumbers), bonusBall);
            return true;
        } catch (IllegalArgumentException e) {
            Output.showError(e);
            return false;
        }
    }

    private Optional<LottoNumber> getLottoNumberByUserString(String userinput) {
        try {
            int number = Integer.parseInt(userinput);
            return Optional.of(new LottoNumber(number));
        } catch (IllegalArgumentException e) {
            Output.showError(e);
            return Optional.empty();
        }
    }
}
