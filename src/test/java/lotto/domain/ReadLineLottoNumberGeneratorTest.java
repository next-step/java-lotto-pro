package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ReadLineLottoNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,A,5", "1,2,4,8,14,BC"})
    void 입력한_값에_정수가_아닌_값이_있으면_에러_발생(String readNumber) {
        assertThatThrownBy(() -> new ReadLineLottoNumberGenerator(readNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.정수값이_아님.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,46,5", "1,1,3,5,14,-1"})
    void 입력한_값에_1_45_사이가_아닌_값_있으면_에러_발생(String readNumber) {
        assertThatThrownBy(() -> new ReadLineLottoNumberGenerator(readNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또의_각_숫자는_1이상_45이하.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,35", "1,3,6,41,43,45"})
    void 입력한_값_정상_테스트(String readNumber) {
        LottoNumberGenerator lottoNumberGenerator = new ReadLineLottoNumberGenerator(readNumber);
        assertThat(lottoNumberGenerator.generateLottoNumbers()).allMatch(
                lottoNumber -> readNumber.contains(lottoNumber.toString()));
    }
}
