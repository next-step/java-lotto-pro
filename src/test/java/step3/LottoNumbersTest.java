package step3;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    @DisplayName("중복 번호 선택시 Exception 발생")
    public void testValidateError() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1,1,1,1,1,1);
            LottoNumbers.generate(numbers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate numbers cannot input.");
    }
}
