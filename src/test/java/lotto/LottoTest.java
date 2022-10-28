package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Supplier<List<LottoNumber>> lottoNumbersFixture = () ->
        Arrays.asList(
            LottoNumber.valueOf(9),
            LottoNumber.valueOf(18),
            LottoNumber.valueOf(27),
            LottoNumber.valueOf(36),
            LottoNumber.valueOf(45),
            LottoNumber.valueOf(1)
        );

    @Test
    void 로또는_6개의_로또_번호를_가지고_있어야_한다() {
        Lotto lotto = Lotto.valueOf(lottoNumbersFixture.get());

        assertThat(lotto).isEqualTo(Lotto.valueOf(lottoNumbersFixture.get()));
    }
}
