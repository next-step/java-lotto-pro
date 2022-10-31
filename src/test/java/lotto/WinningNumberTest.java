package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @Test
    void 당첨_번호_객체_생성() {
        assertThat(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isEqualTo(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 번호_6개_맞춘_경우() {
        assertThat(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))).countHit(
                new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))))).isEqualTo(
                6);
    }

    @Test
    void 번호_3개_맞춘_경우() {
        assertThat(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))).countHit(
                new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 10, 20, 30))))).isEqualTo(
                3);
    }
}
