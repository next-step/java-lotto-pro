package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    public void 로또_생성_리스트() {
        Lotto lotto = new Lotto(RandomUtils.createRandomLottoNumber());
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).isSorted();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(number -> number > 0 && number < 46);
    }

    @Test
    public void 당첨번호_일치개수_구하기() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lotto1.checkMatchCount(lotto)).isEqualTo(3);
    }
}
