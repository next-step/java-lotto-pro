package lotto.controller;

import calculator.domain.StringSplitter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        LottoStatistic lottoStatistic = new LottoStatistic(issueLottos(), pickWinningNumbers(), pickBonusNumber());

        printStatistic(lottoStatistic);
    }

    private void printStatistic(LottoStatistic lottoStatistic) {
        view.outputWinningStatistic(lottoStatistic.winningMatchResultCount());
        view.outputEarning(lottoStatistic.lottoEarning());
    }

    private String[] pickWinningNumbers() {
        view.outputWinningNumbers();
        return view.inputWinningNumbers();
    }

    private String pickBonusNumber() {
        view.outputBonusNumber();
        return view.inputBonusNumber();
    }

    private Lottos issueLottos() {
        view.outputOrderPrice();
        String orderPrice = view.inputOrderPrice();

        Lottos lottos = autoLottoIssuer.issue(Money.from(orderPrice));

        view.outputOrderLottoList(lottos);
        return lottos;
    }


}
