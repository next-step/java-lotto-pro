package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoGeneratorUtilTest {
    @Test
    void 숫자1부터_45까지_중복없이_6개_숫자_선택한다() {
        assertThat(LottoGeneratorUtil.generate()).hasSize(6);
    }
}