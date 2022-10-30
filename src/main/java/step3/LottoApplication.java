package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.Lottos;
import step3.domain.Range;
import step3.domain.WinningLotto;
import step3.enums.Rank;
import step3.views.Input;
import step3.views.Output;

public class LottoApplication {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        output.purchase();
        int money = input.inputNumber();
        int purchasingNumber = Rank.calculateLottoCount(input.inputNumber());
        Lottos lottos = initLottos(purchasingNumber);

        output.generateLottos(purchasingNumber, lottos);
        output.winnerNumbers();
        String inputNumbersWithComma = input.inputString();

        output.bonusball();
        int bonusball = input.inputNumber();

        Map<Integer, Integer> statistics = result(lottos, inputNumbersWithComma, bonusball);
        double returnOnInvestmentRate = Rank.statistic(statistics, money);
        output.statistic(statistics, returnOnInvestmentRate);
    }

    static Lottos initLottos(int purchasingNumber) {
        Range range = new Range(1, 45);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchasingNumber; i++) {
            lottoList.add(new Lotto(new LottoNumber(range.getRandomSixNumbers())));
        }
        return new Lottos(lottoList);
    }

    static Map<Integer, Integer> result(Lottos lottos, String inputNumbersWithComma, int bonusball) {
        WinningLotto winningLotto = new WinningLotto(inputNumbersWithComma, bonusball);
        return lottos.calculateWinningBallsEachLotto(winningLotto);
    }

}
