package lotto.domain;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class LottoAutoManager {

    private long amount;

    public void start() {
        Lottos lottos = getLottos();
        ResultView.printPurchaseAckMessage(lottos.count());
        ResultView.printLottos(lottos);

        LottoWinReader lottoWinReader = getLottoWinReader();

        Map<Integer, Integer> statistic = getStatistic(lottoWinReader, lottos);
        ResultView.printCorrespondLottoNumber(statistic);
        ResultView.printTotalRevenueMessage(getRevenue(statistic).percentage());
    }

    private long readAmount() {
        ResultView.printPurchaseAmountMessage();
        return Long.parseLong(InputView.readAmount());
    }

    private Lottos getLottos() {
        try {
            amount = readAmount();
            return LottoMachine.issue(amount);
        } catch (IllegalArgumentException e) {
            return getLottos();
        }
    }

    private LottoWinReader getLottoWinReader() {
        try {
            ResultView.printLastWinLottoNumbersMessage();
            return new LottoWinReader(
                    Arrays.stream(InputView.readWinLottoNumbers().split(","))
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
        ResultView.printWinStatisticMessage();
        LottoStatisticResult lottoStatisticResult = lottoWinReader.win(lottos);
        return lottoStatisticResult.gets(Arrays.asList(3, 4, 5, 6));
    }

    private Revenue getRevenue(Map<Integer, Integer> statistic) {
        return new Revenue(amount, statistic);
    }

}
