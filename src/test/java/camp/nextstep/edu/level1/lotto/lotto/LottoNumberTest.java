package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.common.PositiveNumber;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberTest {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    @Test
    void _1_에서_45_사이의_숫자로_로또_번호가_생성되어야_한다() {
        Random random = new Random();
        int randomValueBetweenValidInt = random.ints(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .findFirst()
                .getAsInt();

        assertThatNoException().isThrownBy(() -> new LottoNumber(randomValueBetweenValidInt));
    }

    @Test
    void _1_에서_45_사이의_문자열_숫자로_로또_번호가_생성되어야_한다() {
        String randomValidStartInt = "1";
        String randomValidEndInt = "45";

        assertThatNoException()
                .isThrownBy(() -> new LottoNumber(new PositiveNumber(randomValidStartInt, false)));
        assertThatNoException()
                .isThrownBy(() -> new LottoNumber(new PositiveNumber(randomValidEndInt, false)));
    }

    @Test
    void _1_에서_45_사이의_숫자가_아닌_값으로_로또_번호를_생성하면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(LOTTO_START_NUMBER - 1));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(LOTTO_END_NUMBER + 1));
    }
}
