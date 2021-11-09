package lotto.domain;

import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호 추가 성공 테스트")
    @Test
    void addLottoNumber_success() {
        // when & then
        Assertions.assertThat(lotto.getLottoNumbers()).hasSize(Lotto.LOTTO_NUMBER_COUNT);
    }

    @DisplayName("로또 번호 추가 실패 테스트")
    @Test
    void addLottoNumber_failure() {
        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> lotto.addLottoNumber(new LottoNumber(1)))
                .withMessage(Lotto.LOTTO_NUMBER_ERROR);
    }

    @DisplayName("로또 번호 최대 개수 테스트")
    @Test
    void lottoNumbers_count() {
        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> lotto.addLottoNumber(new LottoNumber(7)))
                .withMessage(Lotto.LOTTO_NUMBER_COUNT_ERROR);
    }
}
