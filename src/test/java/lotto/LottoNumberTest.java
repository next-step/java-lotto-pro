package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 번호_포함_여부() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumber.contains(1)).isTrue();
    }

    @Test
    void 로또_번호_출력() {
        assertThat(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))).toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }
}