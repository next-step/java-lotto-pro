package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottoTest {
    @Test
    void 나의_로또_생성_테스트() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18));
        MyLotto myLotto = new MyLotto(lottoList);
        assertThat(myLotto.getLottoList()).hasSize(lottoList.size());
    }
}