package lotto_auto.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또_비교후_결과_랭크() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumberList));
        Lotto winningLotto = new Lotto(new LottoNumbers(lottoNumberList));

        assertThat(lotto.matches(winningLotto)).isEqualTo(LottoRank.FIRST);
    }

}
