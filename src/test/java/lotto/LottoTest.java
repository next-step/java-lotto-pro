package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    public void 로또_생성() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        Assertions.assertThat(lottoNumbers).isSorted();
        Assertions.assertThat(lottoNumbers).hasSize(6);
        Assertions.assertThat(lottoNumbers).allMatch(number -> number > 0 && number < 46);
    }
}
