package study.lotto.view;

import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.utils.Console;

public class LottoOrderCountInputView {

    private static final String LOTTO_ORDER_COUNT_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";
    private static final String ORDER_COUNT_NOT_NUMBER_ERROR_MESSAGE =
            "[ERROR] 시도할 횟수는 0 에서 " + Integer.MAX_VALUE + " 까지의 숫자만 입력 가능합니다.";
    private static final String ORDER_COUNT_NOT_EMPTY_ERROR_MESSAGE = "공백을 대신 구매금액을 입력해주세요";

    private LottoOrderCountInputView() {
    }

    public static LottoOrderMoneyRequestDto submit() {
        try {
            return new LottoOrderMoneyRequestDto(getInputOrderCount());
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return submit();
    }

    private static int getInputOrderCount() {
        System.out.println(LOTTO_ORDER_COUNT_INPUT_GUIDE_MESSAGE);
        final String orderCount = Console.readLine();
        validate(orderCount);
        return Integer.parseInt(orderCount.trim());
    }

    private static void validate(final String orderCount) {
        validateNotNull(orderCount);
        validateOrderCount(orderCount);
    }

    private static void validateNotNull(final String orderCount) {
        if (orderCount == null || orderCount.equals("")) {
            throw new InvalidLottoInputViewException(ORDER_COUNT_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static void validateOrderCount(final String orderCount) {
        if (!orderCount.matches(ONLY_NUMBER_REGEX)) {
            throw new InvalidLottoInputViewException(ORDER_COUNT_NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
