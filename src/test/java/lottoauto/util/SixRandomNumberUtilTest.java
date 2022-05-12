package lottoauto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SixRandomNumberUtilTest {
    SixRandomNumberUtil sixRandomNumberUtil = new SixRandomNumberUtil();
    @Test
    void 랜덤숫자_6개_생성() {
        assertThat(sixRandomNumberUtil.makeRandomNumbers().size()).isEqualTo(6);
    }
}