package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"3:3", "45:45", "1:1"}, delimiter = ':')
    void 로또_숫자_1개_생성(int actualNumber, int expectNumber) {
        LottoNumber lottoNumber = LottoNumber.from(actualNumber);
        assertThat(lottoNumber).isEqualTo(LottoNumber.from(expectNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 0, 47, 123})
    void 로또의_각_숫자는_1이상_45이하가_아니면_에러_발생(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또의_각_숫자는_1이상_45이하.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"7:3", "45:40", "10:1"}, delimiter = ':')
    void 로또_번호_비교_시_비교주체가_비교대상보다_더_크면_양수_리턴(int subjectNumber, int compareNumber) {
        assertThat(LottoNumber.from(subjectNumber).compareTo(LottoNumber.from(compareNumber))).isGreaterThan(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"7:7", "40:40", "10:10"}, delimiter = ':')
    void 로또_번호_비교_시_비교주체와_비교대상이_같으면_0_리턴(int subjectNumber, int compareNumber) {
        assertThat(LottoNumber.from(subjectNumber).compareTo(LottoNumber.from(compareNumber))).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"4:7", "30:40", "1:10"}, delimiter = ':')
    void 로또_번호_비교_시_비교주체가_비교대상보다_더_작으면_음수_리턴(int subjectNumber, int compareNumber) {
        assertThat(LottoNumber.from(subjectNumber).compareTo(LottoNumber.from(compareNumber))).isLessThan(0);
    }
}
