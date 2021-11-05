package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("로또 숫자의 개수가 올바르지 않으면 예외가 발생한다.")
    void createThrowException1() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lottoNumbers))
                .withMessageMatching(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자로 로또를 생성하면 예외가 발생한다.")
    void createThrowException2() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lottoNumbers))
                .withMessageMatching(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {
            "1:2:3:4:5:6:SIX_MATCHED",
            "1:2:3:4:5:10:FIVE_MATCHED",
            "1:2:3:4:9:10:FOUR_MATCHED",
            "1:2:3:8:9:10:THREE_MATCHED"
    }, delimiter = ':')
    @DisplayName("당첨 결과를 반환한다.")
    void getWinResult(int number1, int number2, int number3, int number4, int number5, int number6, WinResult expected) {
        // given
        Lotto lotto = new Lotto(Arrays.asList(number1, number2, number3, number4, number5, number6));

        // when
        WinResult winResult = lotto.getWinResult(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // then
        assertThat(winResult).isEqualTo(expected);
    }
}
