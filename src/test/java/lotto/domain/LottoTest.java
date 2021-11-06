package lotto.domain;

import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private Lotto lotto;
    private final int number = 1;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(number));
    }

    @DisplayName("로또 번호 추가 성공 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> number: {0}")
    @ValueSource(ints = {2, 3, 4})
    void addLottoNumber_success(int number) {
        // when
        LottoNumber lottoNumber = new LottoNumber(number);
        lotto.addLottoNumber(lottoNumber);

        // then
        Assertions.assertThat(lotto.getLottoNumbers())
                .contains(lottoNumber);
    }

    @DisplayName("로또 번호 추가 실패 테스트")
    @Test
    void addLottoNumber_failure() {
        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> lotto.addLottoNumber(new LottoNumber(number)))
                .withMessage(Lotto.LOTTO_NUMBER_ERROR);
    }

    @DisplayName("로또 번호 최대 개수 테스트")
    @Test
    void lottoNumbers_count() {
        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() ->
                {
                    for (int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
                        int testNumber = number + (1 + i);
                        lotto.addLottoNumber(new LottoNumber(testNumber));
                    }
                })
                .withMessage(Lotto.LOTTO_NUMBER_COUNT_ERROR);
    }
}
