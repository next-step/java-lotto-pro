package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    public void 로또_생성자_리스트() {
        List<LottoNo> lottoNoList = Arrays.asList(
                new LottoNo(1),
                new LottoNo(10),
                new LottoNo(15),
                new LottoNo(27),
                new LottoNo(35),
                new LottoNo(45));
        new Lotto(lottoNoList);
    }

    @Test
    public void 로또_생성자_가변_인자() {
        new Lotto(1, 10, 15, 27, 35, 45);
    }

    @Test
    public void 로또_생성자_문자열_인자() {
        new Lotto("1, 10, 15, 27, 35, 45");
    }

    @Test
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
            new Lotto(lottoNoList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 로또입니다.");
    }
}
