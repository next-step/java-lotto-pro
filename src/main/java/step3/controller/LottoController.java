package step3.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step3.domain.GradeCalculator;
import step3.domain.Grades;
import step3.domain.Lotto;
import step3.domain.LottoGenerator;
import step3.domain.LottoQuantity;
import step3.domain.LottoWinning;
import step3.domain.Lottos;
import step3.domain.ProfitRateCalculator;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {

    private static final Scanner scanner = new Scanner(System.in);

    public void doLotto() {
        Integer amount = getAmount();
        Lottos lottos = getLottos(amount);
        LottoWinning lottoWinning = getLottoWinning();
        Grades grades = GradeCalculator.getGrades(lottos, lottoWinning);
        Float profitRate = ProfitRateCalculator.getProfitRate(grades, amount);
        ResultView.printTotalGrades(grades);
        ResultView.printProfitRate(profitRate);
    }

    private Integer getAmount() {
        InputView.printRequestAmountMessage();
        String amount = scanner.nextLine();
        return Integer.parseInt(amount);
    }

    private Lottos getLottos(Integer amount) {
        LottoQuantity quantity = LottoQuantity.of(amount);
        ResultView.printLottoQuantityMessage(quantity);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottoList.add(LottoGenerator.generate());
        }
        Lottos lottos = new Lottos(lottoList);
        ResultView.printLottosNumberMessage(lottos);
        return lottos;
    }

    private LottoWinning getLottoWinning() {
        InputView.printRequestWinNumbersMessage();
        String winNumbers = scanner.nextLine();
        List<Integer> winningNumbers = getStringToNumbers(winNumbers);
        InputView.printRequestBonusNumberMessage();
        String bonusNumber = scanner.nextLine();
        return LottoWinning.of(Lotto.of(winningNumbers), Integer.parseInt(bonusNumber));
    }

    private List<Integer> getStringToNumbers(String winNumbers) {
        String trimmedNumbers = winNumbers.replace(" ", "");
        String[] numbers = trimmedNumbers.split(",");
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
