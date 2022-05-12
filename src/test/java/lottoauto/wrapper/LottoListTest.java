package lottoauto.wrapper;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LottoListTest {
    Lotto lotto = new Lotto();
    @Test
    void 로또_리스트_생성_테스트() {
        LottoList lottoList = new LottoList();
        int count = 6;
        for( int i = 0 ; i < count ; i++) {
            lottoList.addLotto(lotto.getLotto());
        }

        assertThat(lottoList.size()).isEqualTo(6);
    }
}