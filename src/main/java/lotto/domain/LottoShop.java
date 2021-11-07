package lotto.domain;

import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleResultView;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class LottoShop {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoShop() {
        this.inputView = new ConsoleInputView();
        this.resultView = new ConsoleResultView();
        this.lottoMachine = new LottoMachine(new RandomNumberGenerator());
    }

    public void open() {
        PurchaseAmount amount = readAmount();
        Lottos lottos = getLottos(amount);
        resultView.printPurchaseAckMessage(lottos.count());
        resultView.printLottos(lottos);

        LottoWinReader lottoWinReader = getLottoWinReader();

        Map<Integer, Integer> statistic = getStatistic(lottoWinReader, lottos);
        resultView.printCorrespondLottoNumber(statistic);
        Revenue revenue = getRevenue(amount, statistic);
        resultView.printTotalRevenueMessage(revenue.percentage());
    }

    private PurchaseAmount readAmount() {
        try {
            resultView.printPurchaseAmountMessage();
            return new PurchaseAmount(Long.parseLong(inputView.readAmount()));
        } catch (IllegalArgumentException e) {
            return readAmount();
        }
    }

    private Lottos getLottos(PurchaseAmount amount) {
        return lottoMachine.issue(amount);
    }

    private LottoWinReader getLottoWinReader() {
        try {
            resultView.printLastWinLottoNumbersMessage();
            return new LottoWinReader(
                    Arrays.stream(inputView.readWinLottoNumbers().split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .distinct()
                            .collect(toList())
            );
        } catch (IllegalArgumentException e) {
            return getLottoWinReader();
        }
    }

    private Map<Integer, Integer> getStatistic(LottoWinReader lottoWinReader, Lottos lottos) {
        resultView.printWinStatisticMessage();
        LottoStatistic lottoStatistic = lottoWinReader.distinguish(lottos);
        List<Integer> correspondedLottoNumbers = Arrays.asList(3, 4, 5, 6);
        return lottoStatistic.result(correspondedLottoNumbers);
    }

    private Revenue getRevenue(PurchaseAmount amount, Map<Integer, Integer> statistic) {
        return new Revenue(amount, statistic);
    }

}
