package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoNumber 테스트")
class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 생성한다.")
    void create() {
        // given
        int number = 1;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(ints = {0, 46})
    @DisplayName("범위를 벗어난 숫자로 로또 번호를 생성하면 예외가 발생한다.")
    void createThrowException(int input) {
        // given
        List<Integer> lottoNumbers = Arrays.asList(0, 2, 3, 4, 5, 6);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(input))
                .withMessageMatching(Message.LOTTO_NUMBER_BOUND_ERROR.getMessage());
    }
}
