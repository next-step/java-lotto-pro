package step3;

import java.util.List;
import step3.domain.LottoService;
import step3.views.Input;
import step3.views.Output;

public class LottoApplication {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        LottoService lottoService = new LottoService();

        output.purchase();
        int money = input.inputNumber();
        int purchasingNumber = lottoService.calculateLottoCount(money);
        lottoService.generateLottos(purchasingNumber);

        output.winnerNumbers();
        String winnerNumbersWithComma = input.inputString();
        List<Integer> winnerNumbers = lottoService.gainWinnerNumbers(winnerNumbersWithComma);
        lottoService.matchWinningNumbers(winnerNumbers);

        output.statistic(lottoService.getStatistics(), lottoService.statisticLottos(money));


    }
}
