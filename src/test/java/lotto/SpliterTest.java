package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SpliterTest {
    @Test
    void 입력값_리스트_생성() {
        Spliter spliter = new Spliter();
        LottoNumbers lottoNumbers = spliter.split("1, 2, 3");
        assertThat(lottoNumbers.contains(LottoNumber.from(1))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.from(2))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.from(3))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.from(4))).isFalse();
    }
}
