package step3;

import step3.domain.Lottos;
import step3.domain.LottosGenerator;
import step3.viewer.LottoViewer;

public class LottoMain {
    public static void main(String[] args) {
        try {
            startLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startLotto() {
        final int price = LottoViewer.inputPrice();
        final Lottos lottos = LottosGenerator.generateLottos(price);
        LottoViewer.printLottos(lottos);
        final String winningNumbers = LottoViewer.inputWinningNumbers();
    }
}
