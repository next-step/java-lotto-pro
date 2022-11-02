package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 숫자 개수 확인")
    @Test
    void 로또_숫자_개수() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));
        lotto.addLottoNumber(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(3));
        lotto.addLottoNumber(new LottoNumber(4));
        lotto.addLottoNumber(new LottoNumber(5));
        assertThat(lotto.checkLottoNumberCount()).isFalse();

        lotto.addLottoNumber(new LottoNumber(6));
        assertThat(lotto.checkLottoNumberCount()).isTrue();
    }
}
