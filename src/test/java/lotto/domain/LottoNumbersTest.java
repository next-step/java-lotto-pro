package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("lotto.domain.LottoNumbersArgs#lottoNumbersTest_ok")
    @DisplayName("로또 넘버 리스트 생성 - 성공")
    public void lottoNumbersTest_ok(List<Integer> input) {
        assertThat(new LottoNumbers(input))
                .isInstanceOf(LottoNumbers.class);
    }

    @ParameterizedTest
    @MethodSource("lotto.domain.LottoNumbersArgs#lottoNumberSizeTest")
    @DisplayName("로또 넘버는 6개의 숫자로 구성한다.")
    public void lottoNumberSizeTest(List<Integer> input) {
        assertThatThrownBy(() -> new LottoNumbers(input))
                .isInstanceOf(LottoSizeException.class);
    }

    @ParameterizedTest
    @MethodSource("lotto.domain.LottoNumbersArgs#lottoNumberDuplicateTest")
    @DisplayName("중복된 숫자는 입력할 수 없다.")
    public void lottoNumberDuplicateTest(List<Integer> input) {
        assertThatThrownBy(() -> new LottoNumbers(input))
                .isInstanceOf(DuplicateNumberException.class);
    }

}