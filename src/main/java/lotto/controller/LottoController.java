package lotto.controller;

import java.util.Scanner;
import lotto.generator.InputLottoNumberGenerator;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.util.StringToIntegerConverter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final Scanner scanner;

    public LottoController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        InputView.printPurchaseGuide();
        Lottos lottos = Lottos.buy(Money.valueOf(StringToIntegerConverter.parseInt(scanner.nextLine())));
        ResultView.printPurchasedLottos(lottos);
        InputView.printWinningLottoInputGuide();
        Lotto winningLotto = Lotto.draw(new InputLottoNumberGenerator(scanner.nextLine()));
        InputView.printBonusLottoNumberInputGuide();
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(StringToIntegerConverter.parseInt(scanner.nextLine()));
        LottoStatistics lottoStatistics = lottos.lottoStatistics(winningLotto, bonusLottoNumber);
        ResultView.printWinningStatistics(lottoStatistics, lottos.totalPrice());
    }
}
