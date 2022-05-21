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
        WinningLotto winningLotto = null;
        try {
            winningLotto = WinningLotto.of(lotto,
                    LottoNumber.valueOf(StringToIntegerConverter.parseInt(scanner.nextLine())));
        } catch (Exception e) {
            decideWinningLotto();
        }
        return winningLotto;
    }

    private Lotto getWinningLotto() {
        InputView.printWinningLottoInputGuide();
        Lotto lotto = null;
        try {
            lotto = Lotto.draw(new InputLottoNumberGenerator(scanner.nextLine()));
        } catch (Exception e) {
            getWinningLotto();
        }
        return lotto;
    }

    private Lottos purchaseLottos(Money totalMoney, int manualLottoCount) {
        InputView.printManualPurchaseLottoNumberGuide();
        Lottos lottos = null;
        try {
            lottos = Lottos.purchase(totalMoney, pickManualLottos(manualLottoCount));
        } catch (Exception e) {
            purchaseLottos(totalMoney, manualLottoCount);
        }
        return lottos;
    }

    private int getManualPurchaseLottoCount() {
        InputView.printManualPurchaseLottoCountGuide();
        int manualPurchasedLottoCount = 0;
        try {
            manualPurchasedLottoCount = StringToIntegerConverter.parseInt(scanner.nextLine());
        } catch (Exception e) {
            getManualPurchaseLottoCount();
        }
        return manualPurchasedLottoCount;
    }

    private Money openWallet() {
        InputView.printPurchaseGuide();
        Money totalMoney = null;
        try {
            totalMoney = Money.valueOf(StringToIntegerConverter.parseInt(scanner.nextLine()));
        } catch (Exception e) {
            openWallet();
        }
        return totalMoney;
    }

    private List<Lotto> pickManualLottos(int manualLottoCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(Lotto.draw(new InputLottoNumberGenerator(scanner.nextLine())));
        }
        return manualLottos;
    }
}
