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
                .withMessageMatching(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage().replace("%d", "\\d+"));
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

    @Test
    @DisplayName("입력받은 로또 번호와 로또 숫자의 일치 개수를 반환한다.")
    void getWinningResult() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        // when
        int matchedCount = lotto.getMatchedCount(winningLotto);

        // then
        assertThat(matchedCount).isEqualTo(3);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    @DisplayName("로또 숫자의 포함 여부를 반환한다.")
    void isContained(int number, boolean expected) {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        boolean contained = lotto.isContained(new LottoNumber(number));

        // then
        assertThat(contained).isEqualTo(expected);
    }
}
