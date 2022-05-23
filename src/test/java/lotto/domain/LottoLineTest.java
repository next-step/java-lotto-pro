package lotto.domain;

import java.util.Arrays;
import lotto.exception.LottoLineDuplicationException;
import lotto.exception.LottoLineSizeException;
import lotto.exception.LottoNumberRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoLineTest {

    @Test
    @DisplayName("로또번호 세트 1개를 구성하는 로또번호가 6개여야 한다.")
    void 로또번호_1개_세트_숫자개수() {
        Assertions.assertThat(
                new LottoLine(Arrays.asList(1, 2, 3, 4, 5, 6)).toLottoLineDTO().getLottoLineSize())
            .isEqualTo(6);
    }

    @Test
    @DisplayName("로또번호 세트 1개를 구성하는 로또번호의 개수가 6개를 초과할 경우 예외가 발생되어야 한다.")
    void 로또번호_1개_세트_숫자개수_초과_예외() {
        Assertions.assertThatThrownBy(() -> new LottoLine(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(LottoLineSizeException.class);
    }

    @Test
    @DisplayName("로또번호 세트 1개를 구성하는 로또번호에 중복된 숫자가 있으면 예외가 발생되어야 한다.")
    void 로또번호_1개_세트_숫자_중복_예외() {
        Assertions.assertThatThrownBy(() -> new LottoLine(Arrays.asList(1, 2, 3, 4, 5, 3)))
            .isInstanceOf(LottoLineDuplicationException.class);
    }

    @Test
    @DisplayName("로또번호 세트 1개를 구성하는 로또번호에 1 ~ 45의 범위를 벗어나는 숫자가 있으면 예외가 발생되어야 한다.")
    void 로또번호_범위_예외() {
        Assertions.assertThatThrownBy(() -> new LottoLine(Arrays.asList(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(LottoNumberRangeException.class);
    }

    @DisplayName("로또번호 세트 2개를 비교해서 같은 로또번호의 개수가 일치해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:7, 8, 9, 10, 11, 12:0",
        "1, 8, 15, 24, 34, 44:1, 15, 18, 23, 43, 44:3",
        "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6"}
        , delimiter = ':')
    void 로또번호_세트_비교(String firstInputs, String secondInputs, int matchCount) {
        // given
        LottoLine firstLottoLine = new LottoLine(firstInputs);
        LottoLine secondLottoLine = new LottoLine(secondInputs);
        LottoNumber bonusNumber = new LottoNumber(45);

        // when
        int expectedMatchCount = firstLottoLine.getMatchCount(secondLottoLine, bonusNumber)
            .getMatchCount();

        // then
        Assertions.assertThat(expectedMatchCount).isEqualTo(matchCount);
    }

    @DisplayName("보너스번호를 보유하고 있으면 true를 반환해야 한다.")
    @Test
    void 보너스번호_보유여부() {
        // given
        LottoLine lottoLine = new LottoLine(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);

        // when
        boolean expectedResult = lottoLine.hasBonusNumber(bonusNumber);

        // then
        Assertions.assertThat(expectedResult).isTrue();
    }

}