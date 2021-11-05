package lotto.domain;

import static lotto.domain.LottoNumbersFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoNumbersFactoryTest {
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
}
