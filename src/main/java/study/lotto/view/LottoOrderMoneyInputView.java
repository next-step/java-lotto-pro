package study.lotto.view;

import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.utils.Console;

public class LottoOrderMoneyInputView {

    private static final String LOTTO_ORDER_MONEY_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";
    private static final String ORDER_MONEY_NOT_NUMBER_ERROR_MESSAGE =
            "시도할 횟수는 0 에서 " + Integer.MAX_VALUE + " 까지의 숫자만 입력 가능합니다.";
    private static final String ORDER_MONEY_NOT_EMPTY_ERROR_MESSAGE = "공백을 대신 구매금액을 입력해주세요.";
    private static final String ORDER_MONEY_NOT_ENOUGH_ERROR_MESSAGE =
            "최소 1000 이상의 값을 입력해주세요.";

    private LottoOrderMoneyInputView() {
    }

    public static LottoOrderMoneyRequestDto submit() {
        try {
            return new LottoOrderMoneyRequestDto(getInputOrderMoney());
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return submit();
    }

    private static int getInputOrderMoney() {
        System.out.println(LOTTO_ORDER_MONEY_INPUT_GUIDE_MESSAGE);
        final String money = Console.readLine();
        validate(money);
        return Integer.parseInt(money.trim());
    }

    private static void validate(final String money) {
        validateNotNull(money);
        validateOnlyNumber(money);
        validateMinimum(money);
    }

    private static void validateMinimum(final String money) {
        if (Integer.parseInt(money) < 1000) {
            throw new InvalidLottoInputViewException(ORDER_MONEY_NOT_ENOUGH_ERROR_MESSAGE);
        }
    }

    private static void validateNotNull(final String money) {
        if (money == null || money.equals("")) {
            throw new InvalidLottoInputViewException(ORDER_MONEY_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static void validateOnlyNumber(final String money) {
        if (!money.matches(ONLY_NUMBER_REGEX)) {
            throw new InvalidLottoInputViewException(ORDER_MONEY_NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
