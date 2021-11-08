package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;

public class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers.MAX_LOTTO_NUMBERS_SIZE 와 일치 하지 않는경우 예외 발생한다.")
    void createLottoNumbersByBuyCount() {
        // given
        int[] overSizeNumbers = new int[] {1, 2, 3, 4, 5, 6, 7};

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoNumbers(overSizeNumbers);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("중복숫자 생성시 예외 발생한다.")
    void lottoNumbersCheckIsDuplicate() {
        // given
        int[] numbers = {1, 2, 3, 4, 6, 6};

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoNumbers(numbers);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("보너스 숫자 포함여부체크, true 를 반환한다.")
    void isBonusContain() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // when
        LottoNumber bonusLottoNumber = new LottoNumber(1);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        // then
        boolean isBonusContain = lottoNumbers.isBonusContain(bonusLottoNumber);
        assertThat(isBonusContain).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,2,3,4,5,6:1,2,3,4,5,6:6",
        "1,2,3,4,5,6:1,2,3,4,5,7:5",
        "1,2,3,4,5,6:1,2,3,4,8,7:4",
        "1,2,3,4,5,6:1,2,3,9,8,7:3",
        "1,2,3,4,5,6:1,2,10,9,8,7:2",
        "1,2,3,4,5,6:1,11,10,9,8,7:1",
        "1,2,3,4,5,6:12,11,10,9,8,7:0",
    }, delimiter = ':')
    @DisplayName("구매로또 번호 와 지난주로또 번호의 일치갯수 일치 검증")
    void containCount(String buyNumbersStr, String winNumbersStr, int expected) {
        // given
        int[] numbers = parseNumbers(buyNumbersStr);
        int[] winNumbers = parseNumbers(winNumbersStr);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winLottoNumbers = new LottoNumbers(winNumbers);

        // then
        assertThat(lottoNumbers.containCount(winLottoNumbers)).isEqualTo(expected);
    }

    private int[] parseNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
    }

}
