package study.step3;

import study.step3.helper.LottoMaker;
import study.step3.models.*;
import study.step3.views.InputView;
import study.step3.views.ResultView;

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
