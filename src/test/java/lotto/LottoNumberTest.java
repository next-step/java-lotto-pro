package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 번호_생성() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
