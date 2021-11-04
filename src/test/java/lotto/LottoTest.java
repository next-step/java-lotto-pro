package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lotto 테스트")
class LottoTest {

    @Test
    @DisplayName("로또를 생성한다.")
    void create() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(lottoNumbers);

        // then
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("중복된 숫자로 로또를 생성하면 예외가 발생한다.")
    void createThrowException() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lottoNumbers))
                .withMessageMatching(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
