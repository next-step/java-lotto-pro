package lotto;

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
        final Lottos lottos = LottosGenerator.generateLottos(price);
        LottoViewer.printLottos(lottos);
        final LottoWinningNumbers winningNumbers =
                new LottoWinningNumbers(
                        LottoViewer.inputWinningNumbers(),
                        LottoViewer.inputBonusNumber()
                );
        final LottosWinningStatistics lottosWinningStatistics = new LottosWinningStatistics(lottos, winningNumbers);
        LottoViewer.printStatistics(lottosWinningStatistics);
    }
}
