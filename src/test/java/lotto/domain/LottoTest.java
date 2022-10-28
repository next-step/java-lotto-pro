package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 구입금액에_따라_갯수를_계산한다() {
        assertThat(new Lotto(14000).getPurchaseLottoList()).hasSize(14);
        assertThat(new Lotto(1200).getPurchaseLottoList()).hasSize(1);
        assertThat(new Lotto(1999).getPurchaseLottoList()).hasSize(1);
        assertThat(new Lotto(2000).getPurchaseLottoList()).hasSize(2);
        assertThatThrownBy(() -> new Lotto(900))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호를_입력받아_당첨결과를_얻는다() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoNumber(Arrays.asList(1, 4, 5, 7, 8, 9)),
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)),
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)),
            new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9))
        ));
        LottoResult result = lotto.getResult(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(result.matches(3)).isEqualTo(2);
        assertThat(result.matches(4)).isEqualTo(1);
        assertThat(result.matches(5)).isEqualTo(1);
        assertThat(result.matches(6)).isEqualTo(1);
    }

}