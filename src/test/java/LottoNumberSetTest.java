import lotto.LottoNumber;
import lotto.LottoNumberSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberSetTest {

    @Test
    void 생성_예외_개수() {
        assertThatThrownBy(() -> {
            LottoNumberSet lottoNumberSet = new LottoNumberSet(Arrays.asList(1, 2, 5, 25, 30, 42, 44));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumberSet.ILLEGAL_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    void 생성_예외_중복() {
        assertThatThrownBy(() -> {
            LottoNumberSet lottoNumberSet = new LottoNumberSet(Arrays.asList(1, 2, 25, 25, 30, 42));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumberSet.NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 22, 40})
    void 번호_일치(int input) {
        LottoNumberSet lottoNumberSet = new LottoNumberSet(Arrays.asList(1, 2, 3, 10, 22, 40));
        boolean result = lottoNumberSet.has(new LottoNumber(input));
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 7, 20, 45})
    void 번호_불일치(int input) {
        LottoNumberSet lottoNumberSet = new LottoNumberSet(Arrays.asList(1, 2, 3, 10, 22, 40));
        boolean result = lottoNumberSet.has(new LottoNumber(input));
        assertThat(result).isFalse();
    }
}
