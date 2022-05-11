package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트(정상)")
    public void 로또_생성_테스트_정상() {
        List<LottoNo> lottoNoList = Arrays.asList(
                new LottoNo(1),
                new LottoNo(10),
                new LottoNo(15),
                new LottoNo(27),
                new LottoNo(35),
                new LottoNo(45));
        Lotto lotto = new Lotto(lottoNoList);
    }

    @Test
    @DisplayName("로또 생성 테스트(비정상)")
    public void 로또_생성_테스트_비정상() {
        List<LottoNo> lottoNoList = Arrays.asList(
                new LottoNo(1),
                new LottoNo(10),
                new LottoNo(15),
                new LottoNo(27),
                new LottoNo(35),
                new LottoNo(40),
                new LottoNo(45));
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(lottoNoList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 로또입니다.");
    }
}
