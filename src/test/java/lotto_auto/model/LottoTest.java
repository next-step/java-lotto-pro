package lotto_auto.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = "1, 2, 3, 4, 5, 6")
    void 로또_비교후_결과_랭크(String lottoNumbers) {
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
        Lotto winningLotto = new Lotto(new LottoNumbers(lottoNumbers));

        assertThat(lotto.matches(winningLotto)).isEqualTo(LottoRank.FIRST);
    }

}
