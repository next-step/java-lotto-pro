package lotto.model;

import static lotto.model.LottoNumbers.*;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumbersTest {
    @ParameterizedTest
    @DisplayName(NUMBER_SIZE + "개의 숫자로 구성되어 있지 않을 경우 예외 발생")
    @MethodSource("provideIllegalNumbers")
    void 객체_생성_시_유효성_검사(NumberSupplier numberSupplier) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoNumbers(numberSupplier)
        ).withMessage(NUMBER_SIZE_ERR_MSG);
    }

    private static Stream<NumberSupplier> provideIllegalNumbers() {
        return Stream.of(
            new ManualNumberSupplier(1, 2, 3, 4, 5),
            new ManualNumberSupplier(1, 2, 3, 4, 5, 6, 7)
        );
    }
}
