package lotto.controller;

import calculator.domain.StringSplitter;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoRandomFactory;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomNumberMachine;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final LottoIssuer autoLottoIssuer;

    public LottoController(View view) {
        this.view = view;
        LottoRandomFactory factory = new LottoRandomFactory(new RandomNumberMachine());
        autoLottoIssuer = new LottoIssuer(factory);
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
        Lottos autoLottos = autoLottoIssuer.issueMore(manualLottos, orderPrice);

        view.outputOrderLottoList(manualLottos, autoLottos);

        return manualLottos.add(autoLottos);
    }


    private Lottos issueManualLotto() {
        view.outputManualLottoSize();
        int manualLottoSize = view.inputManualLottoSize();

        view.outputManualLottoNumbers();
        String[] manualLottoNumbers = view.inputManualNumbers(manualLottoSize);

        List<String[]> manualLottos = createManualLottos(manualLottoNumbers);
        return autoLottoIssuer.issueManually(manualLottos);
    }

    private List<String[]> createManualLottos(String[] manualLottoNumbers) {
        List<String[]> manualLottos = new ArrayList<>();

        for (String lottoNumber : manualLottoNumbers) {
            manualLottos.add(StringSplitter.split(lottoNumber));
        }
        return manualLottos;
    }
}
