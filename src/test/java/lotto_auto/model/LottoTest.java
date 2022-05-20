package lotto_auto.model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private static Lotto lotto;
    @BeforeAll
    static void setup() {
        Set<LottoNumber> lottoNumberList = new HashSet<>(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6)));

        lotto = new Lotto(new LottoNumbers(lottoNumberList));
    }

    @Test
    void isContains_테스트() {
        assertThat(lotto.isContain(new LottoNumber(1))).isTrue();
    }
    @Test
    void 같은_로또번호_갯수_체크() {
        Set<LottoNumber> lottoNumberList = new HashSet<>(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6)));

        Lotto other = new Lotto(new LottoNumbers(lottoNumberList));

        assertThat(lotto.countSameLottoNumber(other)).isEqualTo(6);
    }
}
