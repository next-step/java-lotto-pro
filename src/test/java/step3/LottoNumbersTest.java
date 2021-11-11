package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.factory.LottoNumbersFactory;

public class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers.MAX_LOTTO_NUMBERS_SIZE 와 일치 하지 않는경우 예외 발생한다.")
    void createLottoNumbersByBuyCount() {
        // given
        List<LottoNumber> overSizeNumbers = LottoNumbersFactory.createManualLottoNumbersToList(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                LottoNumbers.of(overSizeNumbers);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("중복숫자 생성시 예외 발생한다.")
    void lottoNumbersCheckIsDuplicate() {
        // given
        List<LottoNumber> overSizeNumbers = LottoNumbersFactory.createManualLottoNumbersToList(
            Arrays.asList(1, 2, 3, 4, 6, 6));

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                LottoNumbers.of(overSizeNumbers);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("보너스 숫자 포함여부체크, true 를 반환한다.")
    void isBonusContain() {
        // given
        List<LottoNumber> numbers = LottoNumbersFactory.createManualLottoNumbersToList(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        LottoNumber bonusLottoNumber = LottoNumber.of(1);
        LottoNumbers lottoNumbers = LottoNumbers.of(numbers);

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
        List<LottoNumber> numbers = LottoNumbersFactory.createManualLottoNumbersToList(parseNumbers(buyNumbersStr));
        List<LottoNumber> winNumbers = LottoNumbersFactory.createManualLottoNumbersToList(parseNumbers(winNumbersStr));

        // when
        LottoNumbers lottoNumbers = LottoNumbers.of(numbers);
        LottoNumbers winLottoNumbers = LottoNumbers.of(winNumbers);

        // then
        assertThat(lottoNumbers.containCount(winLottoNumbers)).isEqualTo(expected);
    }

    private List<Integer> parseNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
