package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 46;

    @ParameterizedTest(name = "로또_번호_하나는_1부터_45까지의_숫자이어야_한다 / {0}")
    @MethodSource("로또_번호_1부터_45까지_생성")
    void 로또_번호_하나는_1부터_45까지의_숫자이어야_한다(int number) {
        Lotto lotto = Lotto.valueOf(number);

        assertThat(lotto).isEqualTo(Lotto.valueOf(number));
    }

    static IntStream 로또_번호_1부터_45까지_생성() {
        return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE);
    }

    @ParameterizedTest(name = "로또번호_엣지_케이스_테스트_1과_46을_넣는다")
    @ValueSource(ints = {0, 46})
    void 로또번호_엣지_케이스_테스트_0과_46을_넣는다(int exceptionNumber) {
        assertThatThrownBy(() -> Lotto.valueOf(exceptionNumber))
            .isInstanceOf(RuntimeException.class);
    }
}
