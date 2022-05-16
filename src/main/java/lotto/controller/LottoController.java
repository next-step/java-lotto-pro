package lotto.controller;

import calculator.domain.StringSplitter;
import lotto.domain.AutoLottoIssuer;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final AutoLottoIssuer autoLottoIssuer;


    public LottoController(View view, AutoLottoIssuer autoLottoIssuer) {
        this.view = view;
        this.autoLottoIssuer = autoLottoIssuer;
    }

    public void start() {
        view.outputOrderPrice();

        String orderPrice = view.inputOrderPrice();

        Lottos lottos = autoLottoIssuer.issue(Money.from(orderPrice));

        view.outputOrderLottoList(lottos);

        view.outputWinningNumbers();

        String winningNumbers = view.inputWinningNumbers();

        StringSplitter.split(winningNumbers);

        LottoStatistic lottoStatistic = new LottoStatistic(lottos, StringSplitter.split(winningNumbers));

        view.outputStatistic(lottoStatistic);

    }


}
