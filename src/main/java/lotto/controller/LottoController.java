package lotto.controller;

import calculator.domain.StringSplitter;
import lotto.domain.AutoLottoIssuer;
import lotto.domain.LottoRandomFactory;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomNumberMachine;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final AutoLottoIssuer autoLottoIssuer;

    public LottoController(View view) {
        this.view = view;
        LottoRandomFactory factory = new LottoRandomFactory(new RandomNumberMachine());
        autoLottoIssuer = new AutoLottoIssuer(factory);
    }

    public void start() {

        LottoStatistic lottoStatistic = new LottoStatistic(issueLottos(), pickWinningNumbers());

        printStatistic(lottoStatistic);
    }

    private void printStatistic(LottoStatistic lottoStatistic) {
        view.outputWinningStatistic(lottoStatistic.winningMatchResultCount());
        view.outputEarning(lottoStatistic.lottoEarning());
    }

    private String[] pickWinningNumbers() {
        view.outputWinningNumbers();

        String winningNumbers = view.inputWinningNumbers();

        return StringSplitter.split(winningNumbers);
    }

    private Lottos issueLottos() {
        view.outputOrderPrice();
        String orderPrice = view.inputOrderPrice();

        Lottos lottos = autoLottoIssuer.issue(Money.from(orderPrice));

        view.outputOrderLottoList(lottos);
        return lottos;
    }


}
