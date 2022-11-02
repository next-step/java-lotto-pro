package lotto.ui;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    private final InputView inputView = new InputView(new StandardInput());
    private final ResultView resultView = new ResultView(new StandardOutput());

    public void run() {
        Quantity quantity = purchaseLotto();
        LottoTicket lottoTicket = createLottoTicket(quantity);
        WinningLotto winningLotto = inputWinningNumber();
        createStatisticsResult(lottoTicket, winningLotto);
    }

    private void createStatisticsResult(final LottoTicket lottoTicket, final WinningLotto winningLotto) {
        resultView.printWinningStatistics();
        StatisticsResult statisticsResult = StatisticsGenerator.create(lottoTicket, winningLotto);
        resultView.printStatisticsResult(statisticsResult);
    }

    private WinningLotto inputWinningNumber() {
        List<Integer> winningNumber = inputView.inputWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private LottoTicket createLottoTicket(final Quantity quantity) {
        resultView.printMessage(ConsoleMessage.INPUT_PURCHASE_MANUAL_LOTTO_NUMBERS.getMessage());
        List<Lotto> autoLottos = createLottos(new RandomLottoGenerator(), quantity.getCount(PurchaseType.AUTO));
        List<Lotto> manualLottos = createLottos(new ManualLottoGenerator(), quantity.getCount(PurchaseType.MANUAL));
        resultView.printQuantity(quantity);

        List<Lotto> lottos = Stream.of(autoLottos, manualLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        resultView.printPurchasedLottos(lottos);
        return new LottoTicket(lottos);
    }

    private List<Lotto> createLottos(final LottoGenerator lottoGenerator, final int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Supplier<List<Integer>> numbersSupplier = inputView::inputManualLottoNumber;
            List<Integer> generatedNumbers = lottoGenerator.create(numbersSupplier);
            lottos.add(new Lotto(generatedNumbers));
        }
        return lottos;
    }

    private Quantity purchaseLotto() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        int manualQuantity = inputView.inputManualQuantity(purchaseAmount);
        int autoQuantity = InputView.getAvailableAutoQuantity(purchaseAmount, manualQuantity);
        return new Quantity(manualQuantity, autoQuantity);
    }
}
