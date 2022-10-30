package lotto.domain.winningnumber.factory.validation;

import java.util.Set;

public interface WinningNumberValidator {

    String ERROR_COUNT_MESSAGE = "[ERROR] 당첨 번호의 갯수를 다시 확인해주세요.";
    String ERROR_WINNING_NUMBER_TYPE_MESSAGE = "[ERROR] 당첨 번호에 숫자가 아닌 값이 포함되어 있습니다.";
    String ERROR_RANGE_MESSAGE = "[ERROR] 당첨번호에 1 ~ 45 사이의 숫자가 아닌 값이 포함되어 있습니다.";
    String ERROR_SEPARATOR_MESSAGE = "[ERROR] 쉼표(,)로 구분하여 입력해주세요.";
    String ERROR_UNSUPPORTED_OPERATION_MESSAGE = "[ERROR] 지원하지 않는 기능입니다.";

    default void validate(String winningNumbers) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OPERATION_MESSAGE);
    }

    void validate(Set<String> winningNumbers);
}
