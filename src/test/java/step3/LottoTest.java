package step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.ParameterizedTest.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

    private static final String DISPLAY_NAME = DISPLAY_NAME_PLACEHOLDER + " - " + ARGUMENTS_PLACEHOLDER;

    @ParameterizedTest(name = DISPLAY_NAME)
    @CsvSource(value = "1,45")
    void _1에서_45번으로_로또를_만들_수_있다(final int startNumber, final int endNumber) {
        for (int lottoNumber = startNumber; lottoNumber <= endNumber; lottoNumber++) {
            //given
            final Lotto lotto = new Lotto(lottoNumber);

            assertThat(lotto).isNotNull();
        }
    }
}
