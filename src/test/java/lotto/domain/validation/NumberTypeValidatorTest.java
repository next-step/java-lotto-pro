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

class NumberTypeValidatorTest {

    NumberValidator validator = new NumberTypeValidator();
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
    @DisplayName("번호에 숫자가 아닌 값이 있으면 EX 발생")
    @ValueSource(strings = {"a", "@", "ㄱ"})
    void number_type_ex(String ex) {
        numbers.add(ex);
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(numbers))
                .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("번호에 숫자만 있으면 통과")
    void number_type_success() {
        assertThatNoException().isThrownBy(() -> validator.validate(numbers));
    }
}
