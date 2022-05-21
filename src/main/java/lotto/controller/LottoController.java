package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.generator.InputLottoNumberGenerator;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.util.StringToIntegerConverter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final Scanner scanner;

    public LottoController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        Money totalMoney = openWallet();
        int manualLottoCount = getManualPurchaseLottoCount();
        final Lottos lottos = purchaseLottos(totalMoney, manualLottoCount);
        ResultView.printPurchasedLottos(lottos, manualLottoCount);
        final WinningLotto winningLotto = decideWinningLotto();
        LottoStatistics lottoStatistics = lottos.lottoStatistics(winningLotto);
        ResultView.printWinningStatistics(lottoStatistics, lottos.totalPrice());
    }

    private WinningLotto decideWinningLotto() {
        final Lotto lotto = getWinningLotto();
        InputView.printBonusLottoNumberInputGuide();
        try {
            return WinningLotto.of(lotto,
                    LottoNumber.valueOf(StringToIntegerConverter.parseInt(scanner.nextLine())));
        } catch (Exception e) {
            ResultView.printException(e.getMessage());
            return decideWinningLotto();
        }
    }

    private Lotto getWinningLotto() {
        InputView.printWinningLottoInputGuide();
        try {
            return Lotto.draw(new InputLottoNumberGenerator(scanner.nextLine()));
        } catch (Exception e) {
            ResultView.printException(e.getMessage());
            return getWinningLotto();
        }
    }

    private Lottos purchaseLottos(Money totalMoney, int manualLottoCount) {
        InputView.printManualPurchaseLottoNumberGuide();
        try {
            return Lottos.purchase(totalMoney, pickManualLottos(manualLottoCount));
        } catch (Exception e) {
            ResultView.printException(e.getMessage());
            return purchaseLottos(totalMoney, manualLottoCount);
        }
    }

    private int getManualPurchaseLottoCount() {
        InputView.printManualPurchaseLottoCountGuide();
        try {
            return StringToIntegerConverter.parseInt(scanner.nextLine());
        } catch (Exception e) {
            ResultView.printException(e.getMessage());
            return getManualPurchaseLottoCount();
        }
    }

    private Money openWallet() {
        InputView.printPurchaseGuide();
        try {
            return Money.valueOf(StringToIntegerConverter.parseInt(scanner.nextLine()));
        } catch (Exception e) {
            ResultView.printException(e.getMessage());
            return openWallet();
        }
    }

    private List<Lotto> pickManualLottos(int manualLottoCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(Lotto.draw(new InputLottoNumberGenerator(scanner.nextLine())));
        }
        return manualLottos;
    }
}
