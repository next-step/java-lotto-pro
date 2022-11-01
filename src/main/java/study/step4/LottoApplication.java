package study.step4;

import study.step4.helper.LottoMaker;
import study.step4.models.*;
import study.step4.views.InputView;
import study.step4.views.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

        Lottos lottos = LottoMaker.makeLottos(money);
        ResultView.printLottos(lottos);

        String winLottoNumbers = InputView.inputWinningNumbers();

        List<Lotto> rankedLottoList = lottos.rankLottos(new Numbers(winLottoNumbers));
        Winners winners = new Winners(rankedLottoList);
        ResultView.printLottoWinners(winners);
        ResultView.printEarningRate(winners, money);
    }
}
