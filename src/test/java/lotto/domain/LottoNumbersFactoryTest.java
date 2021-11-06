package lotto.domain;

import static lotto.domain.LottoNumbersFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoNumbersFactoryTest {
    @DisplayName("로또 번호 생성 테스트 - 중복되지 않고 정렬된 1~45 사이의 6개의 숫자")
    @RepeatedTest(10)
    void lottoNumbersTest() {
        // when
        List<Integer> lottoNumbers = LottoNumbersFactory.createLottoNumbers();
        int lottoNumberSize = lottoNumbers.size();
        Set<Integer> duplicateNumbers = new HashSet<>(lottoNumbers);

        // then
        assertThat(lottoNumberSize).isEqualTo(LOTTO_NUMBERS_SIZE);
        assertEquals(lottoNumberSize, duplicateNumbers.size());
        assertThat(lottoNumbers).isSorted();
        for (Integer lottoNumber : lottoNumbers) {
            assertTrue(lottoNumber >= LOTTO_NUMBER_MIN_RANGE && lottoNumber <= LOTTO_NUMBER_MAX_RANGE);
        }
    }

    @DisplayName("문자열 번호 숫자로 변환 테스트")
    @Test
    void convertInputNumbersToNumbers() {
        LottoNumbersFactory.createManualLottoNumbers("1,10,15,20,25,30");
    }

    @DisplayName("문자열 번호 숫자로 변환 테스트 - 문자나 음수")
    @Test
    void convertInputNumbersToNumbersException() {
        assertThatThrownBy(() -> LottoNumbersFactory.createManualLottoNumbers("a,b,c,d,e,f"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> LottoNumbersFactory.createManualLottoNumbers("-1,-2,-3,-4,-5,-6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());
    }
}
