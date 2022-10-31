package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoManualGeneratorTest {
    private static LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();


    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"})
    void 정상_생성_Trim_체크(String input) {
        List<Integer> integers = lottoManualGenerator.createLotto(input);
        assertThat(integers).containsExactly(1,2,3,4,5,6);
    }




    @ParameterizedTest
    @NullAndEmptySource
    void 빈_입력(String input) {
        assertThatThrownBy(() -> lottoManualGenerator.createLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 3, 4,5,6", "1,1,1,1,1,1"})
    void 중복된_입력(String input) {
        assertThatThrownBy(() -> lottoManualGenerator.createLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4", "1"})
    void 잘못된_로또_사이즈(String input) {
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