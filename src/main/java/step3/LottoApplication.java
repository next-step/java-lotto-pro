package step3;

import java.util.List;
import java.util.Map;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.utils.Utils;
import step3.views.Input;
import step3.views.Output;

public class LottoApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Lottos lottos = new Lottos();
        Utils utils = new Utils();

        output.purchase();
        int money = input.inputNumber();
        int purchasingNumber = utils.calculateLottoCount(money);

        List<Lotto> lottoList = lottos.generateLottos(purchasingNumber);
        output.generateLottos(purchasingNumber, lottoList);

        output.winnerNumbers();
        String winnerNumbersWithComma = input.inputString();

        output.bonusball();
        int bonusball = input.inputNumber();

        lottos.matchWinningNumbers(winnerNumbersWithComma, bonusball);

        Map<Integer, Integer> statistics = lottos.calculateWinningBallsEachLotto();
        double returnOnInvestmentRate = utils.statisticLottos(statistics, money);
        output.statistic(statistics, returnOnInvestmentRate);

    }

}
