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
    private final Output output = new Output();

    public void run() {
        Money money = getMoney();
        PurchaseInfo purchaseInfo = getPurchasedInfo(money);

        Lottos purchasedLottos = buyLottos(purchaseInfo);
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
        output.showWinningLottoNotice();
        LottoNumbers lottoNumbers = getValidLottoNumbers();
        LottoNumber bonusBall;

        do{
            bonusBall = getBonusLottoNumber();
            isValid = isValidWinningLotto(lottoNumbers, bonusBall);
        }while (!isValid);
        return new WinningLotto(new Lotto(lottoNumbers), bonusBall);
    }

    private LottoNumbers getValidLottoNumbers() {
        boolean isValid;
        Optional<LottoNumbers> lottoNumbers;

        do {
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
        if (lottoString.isEmpty()) {
            return Optional.empty();
        }

        try {
            return Optional.of(getLottoNumberListByStr(lottoString));
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return Optional.empty();
        }
    }

    private Lottos buyLottos(PurchaseInfo info) {
        output.showPurchasedLottoCountNotice(info);
        Lottos manualLottos = getManualLottos(info.getManualLottoCount());
        Lottos autoLottos = LottoGenerator.createLottos(info.getAutoLottoCount());

        return manualLottos.merge(autoLottos);
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
            String delimiter = ",";
            String blank = " ";
            return new LottoNumbers(Arrays.stream(lottoStr.replaceAll(blank , "").split(delimiter))
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoNumber.NOT_NUMBER);
        }
    }

    private LottoCount getManualLottoCount() {
        boolean isValid;
        String userInput;

        do {
            output.showManualLottoCountNotice();
            userInput = UserInputView.getUserInput();
            isValid = isValidLottoCount(userInput);
        } while (!isValid);

        return new LottoCount(userInput);
    }

    private boolean isValidLottoCount(String count) {
        try {
            new LottoCount(count);
            return true;
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return false;
        }
    }

    private boolean isAvailableForPurchase(Money money, LottoCount manualLottoCount) {
        try {
            new PurchaseInfo(money, manualLottoCount);
            return true;
        } catch (Exception e) {
            output.showError(e);
            return false;
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

    private Lottos getManualLottos(int manualLottoCount) {
        output.showPurchaseManualLottoNotice();

        List<LottoNumbers> manualLottoNumbersList = new ArrayList<>();
        for (int i=0; i < manualLottoCount; i++) {
            manualLottoNumbersList.add(getValidLottoNumbers());
        }

        return new Lottos(manualLottoNumbersList.stream().map(Lotto::new).collect(Collectors.toList()));
    }

}
