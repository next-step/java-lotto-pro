package lotto_auto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottosTest {
    @Test
    void 외부에서_로또_추가_시_에러_발생() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6));
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new LottoNumbers(lottoNumberList)),
                new Lotto(new LottoNumbers(lottoNumberList))));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> lottos.getLottoList().add(new Lotto(new LottoNumbers(lottoNumberList))));
    }
}
