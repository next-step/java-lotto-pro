package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.Lottos;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto first = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));
        Lotto second = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 15"));
        lottos = new Lottos(Arrays.asList(first, second));
    }

    @Test
    @DisplayName("외부에서 로또를 추가하면 에러가 발생해야 한다.")
    void lottoAddErrorTest() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
            new LottoNumber(6));
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new LottoNumbers(lottoNumberList)),
            new Lotto(new LottoNumbers(lottoNumberList))));

        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(
                () -> lottos.getLottoList().add(new Lotto(new LottoNumbers(lottoNumberList))));
    }

    @Test
    @DisplayName("로또를 병합하는 테스트")
    void mergeLottos() {
        Lottos mergeLottos = lottos.merge(lottos);
        assertThat(mergeLottos.getHasLottoSize()).isEqualTo(4);
    }
}
