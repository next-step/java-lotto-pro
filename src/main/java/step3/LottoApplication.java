package step3;

import java.util.List;
import java.util.Map;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.WinningLotto;
import step3.enums.Award;
import step3.views.Input;
import step3.views.Output;

public class LottoApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Lottos lottos = new Lottos();

        output.purchase();
        int money = input.inputNumber();
        int purchasingNumber = Award.calculateLottoCount(money);

        List<Lotto> lottoList = lottos.generateLottos(purchasingNumber);
        output.generateLottos(purchasingNumber, lottoList);

        output.winnerNumbers();
        String inputNumbersWithComma = input.inputString();

        output.bonusball();
        int bonusball = input.inputNumber();

        WinningLotto winningLotto = new WinningLotto(inputNumbersWithComma, bonusball);

        lottos.matchWinningNumbers(winningLotto);

        Map<Integer, Integer> statistics = lottos.calculateWinningBallsEachLotto();
        double returnOnInvestmentRate = Award.statistic(statistics);
        output.statistic(statistics, returnOnInvestmentRate);

    }

}
