package study.step3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_만들기() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.makeLotto();

        assertThat(lottoNumbers).hasSize(6);
    }
}
