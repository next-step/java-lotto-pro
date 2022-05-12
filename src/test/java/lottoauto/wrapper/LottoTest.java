package lottoauto.wrapper;

import lottoauto.LottoStarter;
import lottoauto.wrapper.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 번호_생성() {
        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 로또_리스트_생성() {
        LottoList lottoList = new LottoList(5);
        assertThat(lottoList.size()).isEqualTo(5);
    }
}
