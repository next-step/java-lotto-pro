package lotto.domain;

import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleResultView;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.*;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class LottoShop {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoShop() {
        this.inputView = new ConsoleInputView();
        this.resultView = new ConsoleResultView();
        this.lottoMachine = new LottoMachine(new RandomNumberSupplier());
    }

    public void open() {
        Amount totalAmount = readTotalAmount();
        Amount manualAmount = readManualLottosCount(totalAmount);
        Amount autoAmount = subtractAmount(totalAmount, manualAmount);
        Lottos manualLottos = purchaseManualLottos(manualAmount);
        Lottos autoLottos = purchaseAutoLottos(autoAmount);
        resultView.printPurchaseAckMessage(manualLottos.count(), autoLottos.count());
        Lottos totalLottos = combineLottos(manualLottos, autoLottos);
        resultView.printLottos(totalLottos);

        LottoWinReader lottoWinReader = makeLottoWinReader();

        Map<Winnings, Integer> statistic = giveStatistic(lottoWinReader, totalLottos);
        resultView.printCorrespondLottoNumber(statistic);
        Revenue revenue = getRevenue(totalAmount, statistic);
        resultView.printTotalRevenueMessage(revenue.profitRate());
    }

    private Amount readTotalAmount() {
        try {
            resultView.printPurchaseAmountMessage();
            return new Amount(Long.parseLong(inputView.readPurchaseAmount()));
        } catch (IllegalArgumentException e) {
            return readTotalAmount();
        }
    }

    private Amount readManualLottosCount(Amount totalAmount) {
        try {
            resultView.printPurchaseManualLottosCountMessage();
            Amount amount = new Amount(Integer.parseInt(inputView.readManualLottosCount()) * LottoMachine.LOTTO_PRICE);
            subtractAmount(totalAmount, amount);
            return amount;
        } catch (IllegalArgumentException e) {
            return readManualLottosCount(totalAmount);
        }
    }

    private Amount subtractAmount(Amount purchaseAmount, Amount subtractAmount) {
        return purchaseAmount.subtract(subtractAmount);
    }

    private Lottos purchaseManualLottos(Amount amount) {
        try {
            resultView.printPurchaseManualLottosNumberMessage();
            long count = amount.divide(new Amount(LottoMachine.LOTTO_PRICE));
            List<String> numbers = LongStream.rangeClosed(1, count)
                    .mapToObj(n -> inputView.readManualLottosNumber())
                    .collect(toList());
            return lottoMachine.issueManual(numbers);
        } catch (IllegalArgumentException e) {
            return purchaseManualLottos(amount);
        }
    }

    private Lottos purchaseAutoLottos(Amount amount) {
        return lottoMachine.issueAuto(amount);
    }

    private Lottos combineLottos(Lottos manualLottos, Lottos autoLottos) {
        return manualLottos.addLottos(autoLottos);
    }

    private LottoWinReader makeLottoWinReader() {
        try {
            resultView.printLastWinLottoNumbersMessage();
            String readLottoNumbers = inputView.readWinLottoNumbers();
            resultView.printBonusNumberInputMessage();
            String readBonusLottoNumber = inputView.readWinBonusLottoNumber();
            return LottoWinReader.make(readLottoNumbers, readBonusLottoNumber);
        } catch (IllegalArgumentException e) {
            return makeLottoWinReader();
        }
    }

    private Map<Winnings, Integer> giveStatistic(LottoWinReader lottoWinReader, Lottos lottos) {
        resultView.printWinStatisticMessage();
        LottoStatistic lottoStatistic = lottoWinReader.distinguish(lottos);
        List<Winnings> winnings = Arrays.stream(Winnings.values()).collect(toList());
        return lottoStatistic.result(winnings);
    }

    private Revenue getRevenue(Amount amount, Map<Winnings, Integer> statistic) {
        return new Revenue(amount, statistic);
    }

}
