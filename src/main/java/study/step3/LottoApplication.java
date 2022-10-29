package study.step3;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        Lottos lottos = new Lottos();
        List<Lotto> lottoList = lottos.makeLottos(money);
        ResultView.printLottos(lottoList);
        String winLottoNumbers = InputView.inputWinningNumbers();
        Winners winners = lottos.findWinners(winLottoNumbers);
        ResultView.printLottoWinners(winners);
        ResultView.printEarningRate(winners, money);
    }
}
