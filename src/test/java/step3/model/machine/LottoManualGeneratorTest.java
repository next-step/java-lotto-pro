package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.lotto.Lotto;
import step3.model.lotto.LottoNumber;

class LottoManualGeneratorTest {
    private static final LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_입력(String input) {
        assertThatThrownBy(() -> lottoManualGenerator.createLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, b, 4, 7,c", "1, a, b, c,#,%"})
    void 문자_특수문자_입력_LottoNumberInvalid(String input) {
        assertThatThrownBy(() -> lottoManualGenerator.createLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}