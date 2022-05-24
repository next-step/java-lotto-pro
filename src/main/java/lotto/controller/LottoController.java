package lotto.controller;

import lotto.domain.AutoLottoIssuer;
import lotto.domain.Lotto;
import lotto.domain.LottoRandomFactory;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.domain.ManualLottos;
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
        view.outputEarning(lottoStatistic.calculateLottoEarning());
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
        Money orderPrice = Money.from(view.inputOrderPrice());

        Lottos manualLottos = issueManualLotto();
        Money leftMoney = orderPrice.subtract(Lotto.LOTTO_PRICE.multiply(manualLottos.size()));
        
        Lottos autoLottos = issueAutoLottos(leftMoney);
        view.outputOrderLottoList(manualLottos, autoLottos);

        return manualLottos.add(autoLottos);
    }

    private Lottos issueAutoLottos(Money leftMoney) {
        Lottos lottos = autoLottoIssuer.issue(leftMoney);

        return lottos;
    }

    private Lottos issueManualLotto() {
        view.outputManualLottoSize();
        int manualLottoSize = view.inputManualLottoSize();

        view.outputManualLottoNumbers();
        String[] manualLottoNumbers = view.inputManualNumbers(manualLottoSize);

        ManualLottos manualLottos = ManualLottos.of(manualLottoSize, manualLottoNumbers);
        return manualLottos.getLottos();
    }


}
