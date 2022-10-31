package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import step3.domain.*;
import step3.enums.Rank;
import step3.views.Input;
import step3.views.Output;

public class LottoApplication {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        output.purchase();
        int money = input.inputNumber();
        int purchasingNumber = Rank.calculateLottoCount(money);

        Lottos manualLottos = getManualLottos(output, input);
        Lottos totalLottos = initLottos(manualLottos, purchasingNumber);
        output.generateLottos(purchasingNumber, totalLottos);

        WinningLotto winningLotto = gainWinnerLotto(output, input);
        Map<Integer, Integer> statistics =  totalLottos.calculateWinningBallsEachLotto(winningLotto);
        result(output, statistics, money);

    }

    static Lottos getManualLottos(Output output, Input input) {
        output.manualCount();
        int lottoCount = input.inputNumber();
        output.manualNumber();
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            manualLottoList.add(new Lotto(LottoNumbers.gainNumbers(input.inputString())));
        }
        return new Lottos(manualLottoList);
    }

    static Lottos initLottos(Lottos manualLottos, int purchasingNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchasingNumber-manualLottos.getLottos().size(); i++) {
            lottoList.add(new Lotto(LottoNumbers.getRandomSixNumbers()));
        }
        return new Lottos(lottoList).unionLottos(manualLottos);
    }

    static WinningLotto gainWinnerLotto(Output output, Input input) {
        output.winnerNumbers();
        String inputNumbersWithComma = input.inputString();
        output.bonusball();
        int bonusball = input.inputNumber();

        return new WinningLotto(LottoNumbers.gainNumbers(inputNumbersWithComma), bonusball);
    }

    static void result (Output output, Map<Integer, Integer> statistics, int money) {

        double returnOnInvestmentRate = Rank.statistic(statistics, money);
        output.statistic(statistics, returnOnInvestmentRate);
    }

}
