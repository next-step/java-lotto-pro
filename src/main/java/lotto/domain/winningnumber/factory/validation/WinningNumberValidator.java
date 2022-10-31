package lotto.domain.winningnumber.factory.validation;

import java.util.Set;

public interface WinningNumberValidator {

    String ERROR_UNSUPPORTED_OPERATION_MESSAGE = "[ERROR] 지원하지 않는 기능입니다.";

    default void validate(String winningNumbers) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OPERATION_MESSAGE);
    }

    void validate(Set<String> winningNumbers);
}
