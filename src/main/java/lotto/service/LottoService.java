package lotto.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Amount buyLotto() {
        return new Amount(InputView.inputAmount());

    }
    
    public Lottos generateLottos(Amount buyAmount) {
        List<Lotto> manualLottos = buyLottoManual(buyAmount);
        List<Lotto> autoLottos = buyLottoAuto(buyAmount.buyLottoAutoCount(manualLottos.size()));
        Lottos buyLottos = Lottos.from(Stream.of(manualLottos, autoLottos)
            .flatMap(Collection::stream)
            .collect(Collectors.toList()));

        OutputView.outputBuyLottosCount(manualLottos.size(), autoLottos.size());
        OutputView.outputBuyLottos(buyLottos);
        return buyLottos;
    }

    private List<Lotto> buyLottoManual(Amount buyAmount) {
        int manualLottoCount = InputView.inputManualLottoCount();
        buyAmount.purchaseAvailable(manualLottoCount);
        List<Lotto> lottos = InputView.inputManualLottoNumber(manualLottoCount);
        return lottos;
    }

    private List<Lotto> buyLottoAuto(int buyLottoAutoCount) {
        return createLottos(buyLottoAutoCount);
    }

    public WinningLotto winningLotto() {
        return WinningLotto.of(InputView.inputWinningNumbers(), InputView.inputBounsBall());
    }

    public Map<LottoRank, Integer> checkWinnginLotto(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankInfo = lottos.lottoRanksInfo(winningLotto);
        OutputView.outputLottoRank(rankInfo);
        return rankInfo;
    }

    public void calculateLottoYield(Amount buyAmount, Map<LottoRank, Integer> rankInfo) {
        OutputView.outputYield(Amount.calculateLottoYield(buyAmount, rankInfo));
    }

    private List<Lotto> createLottos(int amount) {
        List<Lotto> lottos = Stream.generate(lottoNumberGenerator::generate)
            .map(Lotto::from)
            .limit(amount)
            .collect(Collectors.toList());

        return lottos;
    }
}
