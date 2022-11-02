package lotto.domain.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RangeValidatorTest {

    NumberValidator validator = new RangeValidator();
    Set<String> numbers = new HashSet<>();

    @BeforeEach
    void beforeEach() {
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
    }

    @ParameterizedTest
    @DisplayName("1~45 사이 값이 아니면 EX 발생")
    @ValueSource(strings = {"46", "0", "-1"})
    void range_ex(String ex) {
        numbers.add(ex);
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(numbers))
                .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("1~45 사이 값이면 통과")
    void range_success() {
        assertThatNoException().isThrownBy(() -> validator.validate(numbers));

    }
}
