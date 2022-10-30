package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Amount buyLottoAuto() {
        Amount buyAmount = new Amount(InputView.inputAmount());
        OutputView.outputBuyLottosCount(buyAmount.buyLottoCount());
        return buyAmount;
    }

    public Lottos generateLottos(Amount buyAmount) {
        Lottos lottos = createLottos(buyAmount.buyLottoCount());
        OutputView.outputBuyLottos(lottos);
        return lottos;
    }

    public Lotto winningLotto() {
        return InputView.inputWinningNumbers();
    }

    public Map<LottoRank, Integer> checkWinnginLotto(Lottos lottos, Lotto winningLotto) {
        Map<LottoRank, Integer> rankInfo = lottos.lottoRanksInfo(winningLotto);
        OutputView.outputLottoRank(rankInfo);
        return rankInfo;
    }

    public void calculateLottoYield(Amount buyAmount, Map<LottoRank, Integer> rankInfo) {
        OutputView.outputYield(Amount.calculateLottoYield(buyAmount, rankInfo));
    }

    private Lottos createLottos(int amount) {
        List<Lotto> lottos = Stream.generate(lottoNumberGenerator::generate)
            .map(Lotto::from)
            .limit(amount)
            .collect(Collectors.toList());

        return Lottos.from(lottos);
    }
}
