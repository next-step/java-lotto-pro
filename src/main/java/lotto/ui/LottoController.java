package lotto.ui;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    public void run() {
        Quantity quantity = purchaseLotto();
        LottoTicket lottoTicket = createLottoTicket(quantity);
        WinningLotto winningLotto = inputWinningNumber();
        createStatisticsResult(lottoTicket, winningLotto);
    }

    private void createStatisticsResult(final LottoTicket lottoTicket, final WinningLotto winningLotto) {
        ResultView.printWinningStatistics();
        StatisticsResult statisticsResult = StatisticsGenerator.create(lottoTicket, winningLotto);
        ResultView.printStatisticsResult(statisticsResult);
    }

    private WinningLotto inputWinningNumber() {
        List<Integer> winningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private LottoTicket createLottoTicket(final Quantity quantity) {
        ResultView.printMessage(ConsoleMessage.INPUT_PURCHASE_MANUAL_LOTTO_NUMBERS.getMessage());
        List<Lotto> autoLottos = createLottos(new RandomLottoGenerator(), quantity.getCount(PurchaseType.AUTO));
        List<Lotto> manualLottos = createLottos(new ManualLottoGenerator(), quantity.getCount(PurchaseType.MANUAL));
        ResultView.printQuantity(quantity);

        List<Lotto> lottos = Stream.of(autoLottos, manualLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        ResultView.printPurchasedLottos(lottos);
        return new LottoTicket(lottos);
    }

    private List<Lotto> createLottos(final LottoGenerator lottoGenerator, final int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> generatedNumbers = lottoGenerator.create();
            lottos.add(new Lotto(generatedNumbers));
        }
        return lottos;
    }

    private Quantity purchaseLotto() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        return InputView.inputQuantity(purchaseAmount);
    }
}
