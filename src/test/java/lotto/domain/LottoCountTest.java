package lotto.domain;

import lotto.domain.error.LottoCountErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @ParameterizedTest(name = "lottoCount는 0이하의 숫자를 허용하지 않는다.")
    @ValueSource(ints = {0, -1})
    public void LottoCount_경계값(int lottoCount) throws Exception {
        assertThatThrownBy(() -> {
            new LottoCount(lottoCount);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoCountErrorCode.NOT_ALLOW_SMALLER_THAN_ONE.getMessage());
    }

    @ParameterizedTest(name = "lottoCount가 0 이상인 경우 정상적으로 값이 들어갔는지 확인")
    @ValueSource(ints = {1, 2, 3, 4})
    public void getLottoCount(int lottoCount) throws Exception {
        assertThat(new LottoCount(lottoCount).getLottoCount()).isEqualTo(lottoCount);
    }

    @ParameterizedTest(name = "lottoCount 가 같으면 동등하다")
    @ValueSource(ints = {1, 2, 3, 4})
    public void equals(int lottoCount) throws Exception {
        LottoCount lottoCount1 = new LottoCount(lottoCount);
        LottoCount lottoCount2 = new LottoCount(lottoCount);

        assertThat(lottoCount1).isEqualTo(lottoCount2);
    }
}