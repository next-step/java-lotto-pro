package lotto.controller;

import generator.InputLottoNumberGenerator;
import java.util.Scanner;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import util.StringToIntegerConverter;

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
        LottoStatistics lottoStatistics = lottos.lottoStatistics(winningLotto);
        ResultView.printWinningStatistics(lottoStatistics, lottos.totalPrice());
    }
}
