package step3;

import java.util.List;
import java.util.Map;
import step3.domain.Lotto;
import step3.domain.LottoService;
import step3.domain.Lottos;
import step3.views.Input;
import step3.views.Output;

public class LottoApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Lottos lottos = new Lottos();
        LottoService lottoService = new LottoService();

        output.purchase();
        int money = input.inputNumber();
        int purchasingNumber = lottoService.calculateLottoCount(money);

        output.generateLottos(purchasingNumber);
        List<Lotto> lottoList = lottos.generateLottos(purchasingNumber);

        output.winnerNumbers();
        String winnerNumbersWithComma = input.inputString();
        List<Integer> winnerNumbers = lottoService.gainWinnerNumbers(winnerNumbersWithComma);
        lottoService.matchWinningNumbers(lottoList, winnerNumbers);

        Map<Integer, Integer> statistics = lottoService.calculateWinningBallsEachLotto(lottoList);
        double returnOnInvestmentRate = lottoService.statisticLottos(statistics, money);
        output.statistic(statistics, returnOnInvestmentRate);

    }
}
