package lotto_auto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottosTest {
    @ParameterizedTest
    @ValueSource(strings = "1, 2, 3, 4, 5, 6")
    void 외부에서_로또_추가_시_에러_발생(String lottoNumbers) {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new LottoNumbers(lottoNumbers)),
                new Lotto(new LottoNumbers(lottoNumbers))));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> lottos.getLottoList().add(new Lotto(new LottoNumbers(lottoNumbers))));
    }
}
