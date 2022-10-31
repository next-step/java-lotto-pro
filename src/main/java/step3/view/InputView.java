package step3.view;

import step3.model.Lotto;
import step3.model.LottoCalculator;
import step3.model.LottoGenerator;
import step3.model.LottoNumber;

import java.util.Scanner;

import static step3.constant.Message.*;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    public static void inputPurchasePrice(LottoGenerator lottoGenerator) {
        System.out.println(TOTAL_LOTTO_PRICE_INPUT_MESSAGE);
        lottoGenerator.setPurchasePrice(scanner.nextLine());
    }

    public static void inputLastWeekLottoNumbers(Lotto lotto) {
        System.out.println(LAST_LOTTO_NUMBERS_INPUT_MESSAGE);
        String[] lastweekNumbers = lotto.validateLastWeekWinner(scanner.nextLine());

        lotto = inputLastWeekBonusNumber(lastweekNumbers);
    }

    public static Lotto inputLastWeekBonusNumber(String[] lastWeekLottos) {
        System.out.println(LAST_BONUS_NUMBER_INPUT_MESSAGE);
        return new Lotto(lastWeekLottos, Integer.parseInt(scanner.nextLine()));
    }
}
