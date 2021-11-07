package lotto.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.domain.Bonus;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.utils.ConsoleUtils;
import lotto.utils.ValidationUtils;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static final String ERROR_ONLY_NUMBER = "숫자만 입력 가능합니다.";
    private static final String ERROR_DUPLICATED_NUMBER = "숫자가 중복되었습니다.";
    private static final String ERROR_NUMBER_QUANTITY = "%d개의 숫자를 입력해주세요.";
    private static final String ERROR_NUMBER_RANGE = "%d ~ %d 범위의 숫자만 입력 가능합니다.";

    public Money enterMoney() {
        System.out.println(INSERT_MONEY);
        String number = ConsoleUtils.console();
        if (ValidationUtils.isNumber(number)) {
            return new Money(Integer.parseInt(number));
        }
        System.out.println(ERROR_ONLY_NUMBER);
        return enterMoney();
    }

    public LottoNumbers enterWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBER);
        String[] numbers = ConsoleUtils.console().split(",");
        if (checkWinningNumbers(numbers)) {
            return LottoNumbers.valueOf(Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        }
        return enterWinningNumbers();
    }

    public Bonus enterBonus() {
        System.out.println(INSERT_BONUS_BALL);
        String bonus = ConsoleUtils.console();
        if (!ValidationUtils.isNumber(bonus)) {
            System.out.println(ERROR_ONLY_NUMBER);
            return enterBonus();
        }
        return Bonus.from(Integer.parseInt(bonus));
    }
    
    private boolean checkWinningNumbers(String[] numbers) {
        if (!ValidationUtils.isCorrectQuantity(numbers)) {
            System.out.println(String.format(ERROR_NUMBER_QUANTITY, LottoNumbers.LOTTO_NUMBER_QUANTITY));
            return false;
        }
        if (!ValidationUtils.isCorrectNumber(numbers)) {
            System.out.println(String.format(ERROR_NUMBER_RANGE,LottoNumbers.LOTTO_MIN_NUMBER, LottoNumbers.LOTTO_MAX_NUMBER));
            return false;
        }
        if (ValidationUtils.checkDuplicatedNumber(numbers)) {
            System.out.println(ERROR_DUPLICATED_NUMBER);
            return false;
        }
        return true;
    }

}
