package lotto.controller;

import generator.LottoNumberGenerator;
import generator.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoResultView resultView;
    private final NumberGenerator numberGenerator;

    public LottoController() {
        this.lottoInputView = new LottoInputView();
        this.resultView = new LottoResultView();
        this.numberGenerator = new LottoNumberGenerator();
    }

    public void play() {
        Money money = lottoInputView.inputMoney();
        Lottos lottos = purchaseLottos(money);
    }

    private Lottos purchaseLottos(Money money) {
        LottoCount lottoCount = calculateLottoCountByMoney(money);
        Lottos lottos = Lottos.from(generateAutoLottoNumbers(lottoCount));
        resultView.printLottos(lottos);

        return lottos;
    }

    private List<Lotto> generateAutoLottoNumbers(LottoCount lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount.getCount(); i++) {
            LottoNumbers lottoNumbers = LottoNumbers.generateBy(this.numberGenerator);
            lottos.add(Lotto.from(lottoNumbers));
        }
        return lottos;
    }

    private LottoCount calculateLottoCountByMoney(Money money) {
        return LottoCount.from(money.getMoney() / LottoConstants.LOTTO_PRICE);
    }
}
