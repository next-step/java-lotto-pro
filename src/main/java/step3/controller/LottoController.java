package step3.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step3.domain.GradeCalculator;
import step3.domain.Grades;
import step3.domain.Lotto;
import step3.domain.LottoQuantity;
import step3.domain.Lottos;
import step3.domain.ProfitRateCalculator;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {

    private static final Scanner scanner = new Scanner(System.in);

    public void doLotto() {
        Integer amount = getAmount();
        LottoQuantity quantity = LottoQuantity.of(amount);
        Lottos lottos = getLottos(quantity);
        List<Integer> winNumbers = getWinNumbers();
        Grades grades = GradeCalculator.getGrades(lottos, winNumbers);
        Float profitRate = ProfitRateCalculator.getProfitRate(grades, amount);
        ResultView.printTotalGrades(grades);
        ResultView.printProfitRate(profitRate);
    }

    private Integer getAmount() {
        InputView.printRequestAmountMessage();
        String amount = scanner.nextLine();
        return Integer.parseInt(amount);
    }

    private Lottos getLottos(LottoQuantity quantity) {
        ResultView.printLottoQuantityMessage(quantity);
        Lottos lottos = new Lottos();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottos.add(Lotto.generate());
        }
        ResultView.printLottosNumberMessage(lottos);
        return lottos;
    }

    private List<Integer> getWinNumbers() {
        InputView.printRequestWinNumbersMessage();
        String winNumbers = scanner.nextLine();
        String[] numbers = winNumbers.split(",");
        return Arrays.stream(numbers).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
