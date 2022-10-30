package lotto;

import lotto.domain.LottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {
    @Test
    @DisplayName("로또 n개 구입")
    void 로또_구입() {
        LottoList lottoList = new LottoList();
        lottoList.buyLottos(3);
        assertThat(lottoList.size()).isEqualTo(3);
    }
}
