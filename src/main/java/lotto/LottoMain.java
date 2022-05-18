package lotto;

import lotto.domain.LottosManual;
import lotto.domain.LottosManualCount;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.domain.LottosGenerator;
import lotto.domain.LottosWinningStatistics;
import lotto.domain.Price;
import lotto.viewer.LottoViewer;

public class LottoMain {
    public static void main(String[] args) {
        try {
            startLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startLotto() {
        final Price price = LottoViewer.inputPrice();
        final LottosManualCount lottosManualCount = LottoViewer.inputManualLottosCount(price);
        final LottosManual lottosManual = LottoViewer.inputManualLottos(lottosManualCount);
        final Lottos manualLottos = LottosGenerator.generateLottosManual(lottosManual);
        final Lottos autoLottos = LottosGenerator.generateLottosAuto(lottosManualCount, price);
        final Lottos lottos = LottosGenerator.mergeLottos(manualLottos, autoLottos);
        LottoViewer.printLottos(
                manualLottos.getLottosCount(),
                autoLottos.getLottosCount(),
                lottos
        );
        final LottoWinningNumbers winningNumbers =
                new LottoWinningNumbers(
                        LottoViewer.inputWinningNumbers(),
                        LottoViewer.inputBonusNumber()
                );
        final LottosWinningStatistics lottosWinningStatistics = new LottosWinningStatistics(lottos, winningNumbers);
        LottoViewer.printStatistics(lottosWinningStatistics);
    }
}
