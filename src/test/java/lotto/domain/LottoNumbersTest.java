package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("lotto.domain.LottoNumbersArgs#lottoNumbersTest_ok")
    @DisplayName("로또 넘버 리스트 생성 - 성공")
    public void lottoNumbersTest_ok(List<Integer> input) {
        assertThat(LottoNumbers.fromList(input))
                .isInstanceOf(LottoNumbers.class);
    }

    @ParameterizedTest
    @MethodSource("lotto.domain.LottoNumbersArgs#lottoNumberSizeTest")
    @DisplayName("로또 넘버는 6개의 숫자로 구성한다.")
    public void lottoNumberSizeTest(List<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.fromList(input))
                .isInstanceOf(LottoSizeException.class);
    }

    @ParameterizedTest
    @MethodSource("lotto.domain.LottoNumbersArgs#lottoNumberDuplicateTest")
    @DisplayName("중복된 숫자는 입력할 수 없다.")
    public void lottoNumberDuplicateTest(List<Integer> input) {
        assertThatThrownBy(() -> LottoNumbers.fromList(input))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "11,12,13,14,15,16|0",
            "1,12,13,14,15,16|1",
            "1,2,13,14,15,16|2",
            "1,2,3,14,15,16|3",
            "1,2,3,4,15,16|4",
            "1,2,3,4,5,16|5",
            "1,2,3,4,5,6|6",
    }, delimiter = '|')
    @DisplayName("맞춘 로또 번호 개수 구하기")
    public void matchReduceTest(String input, int resultCount) {
        //given
        LottoNumbers userLottoNumbers = LottoNumbers.fromString("1,2,3,4,5,6");
        LottoNumbers winningLottoNumbers = LottoNumbers.fromString(input);

        //when
        int matchCount = userLottoNumbers.matchReduce(winningLottoNumbers);

        //then
        assertThat(matchCount).isEqualTo(resultCount);
    }

    @Test
    @DisplayName("보너스 번호 틀림")
    public void matchBonusNumberNotMatchingTest() throws Exception {
        //given
        LottoNumbers userLottoNumbers = LottoNumbers.fromString("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(7);
        //when
        boolean isBonusMatch = userLottoNumbers.matchBonusNumber(bonusNumber);

        //then
        assertThat(isBonusMatch).isFalse();
    }

    @Test
    @DisplayName("보너스 번호 맞음")
    public void matchBonusNumberMatchingTest() throws Exception {
        //given
        LottoNumbers userLottoNumbers = LottoNumbers.fromString("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(1);
        //when
        boolean isBonusMatch = userLottoNumbers.matchBonusNumber(bonusNumber);

        //then
        assertThat(isBonusMatch).isTrue();
    }


}