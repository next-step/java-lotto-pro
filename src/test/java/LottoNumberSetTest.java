import lotto.LottoNumberSet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
