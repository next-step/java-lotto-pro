package lotto.domain;

import lotto.domain.error.LottoCountErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void LottoCount_경계값(int lottoCount) throws Exception {
        assertThatThrownBy(() -> {
            new LottoCount(lottoCount);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoCountErrorCode.NOT_ALLOW_SMALLER_THAN_ONE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void getLottoCount(int lottoCount) throws Exception {
        assertThat(new LottoCount(lottoCount).getLottoCount()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void equals(int lottoCount) throws Exception {
        LottoCount lottoCount1 = new LottoCount(lottoCount);
        LottoCount lottoCount2 = new LottoCount(lottoCount);

        assertThat(lottoCount1.equals(lottoCount2)).isTrue();
    }
}