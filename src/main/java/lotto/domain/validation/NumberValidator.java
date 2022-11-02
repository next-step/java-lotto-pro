package lotto.domain.validation;

import java.util.Set;

public interface NumberValidator {

    String ERROR_UNSUPPORTED_OPERATION_MESSAGE = "[ERROR] 지원하지 않는 기능입니다.";

    default void validate(String numbers) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OPERATION_MESSAGE);
    }

    void validate(Set<String> numbers);
}
