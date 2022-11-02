package lotto.domain.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountValidatorTest {

    NumberValidator validator = new CountValidator();
    Set<String> numbers = new HashSet<>();

    @BeforeEach
    void beforeEach() {
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
    }

    @Test
    @DisplayName("번호의 갯수가 6개가 아니면 EX 발생")
    void count_ex() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(numbers))
                .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("번호의 갯수가 6개면 통과")
    void count_success() {
        numbers.add("6");
        assertThatNoException().isThrownBy(() -> validator.validate(numbers));
    }
}
