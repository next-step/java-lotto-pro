package lotto_auto.model;

import lotto_auto.exception.IllegalLottoException;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    public void 로또번호_범위_체크() {
        assertThatExceptionOfType(IllegalLottoException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,100)))
                .withMessage(Lotto.NOT_RANGE_NUMBER);

        assertThatExceptionOfType(IllegalLottoException.class)
                .isThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 100"))
                .withMessage(Lotto.NOT_RANGE_NUMBER);
    }

    @Test
    public void 로또번호_개수_체크() {
        assertThatExceptionOfType(IllegalLottoException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
                .withMessage(Lotto.NOT_MATCHED_NUMBER_SIZE);

        assertThatExceptionOfType(IllegalLottoException.class)
                .isThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6, 7"))
                .withMessage(Lotto.NOT_MATCHED_NUMBER_SIZE);
    }

    @Test
    public void 로또번호_중복_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1,1,2,3,4,5)))
                .withMessage(Lotto.EXIST_DUPLICATE_VALUE);

        assertThatExceptionOfType(IllegalLottoException.class)
                .isThrownBy(() -> new Lotto("1, 1, 2, 3, 4, 5"))
                .withMessage(Lotto.EXIST_DUPLICATE_VALUE);
    }

    @Test
    public void 로또번호_숫자_이외의_값_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new Lotto("a, b, c, 1, 2, 3"))
                .withMessage(Lotto.NOT_NUMBER);
    }

    @Test
    public void 로또_프린트_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1,6,2,3,4,5));
        assertThat(lotto.toString()).isEqualTo("[1, 6, 2, 3, 4, 5]");
    }
}
