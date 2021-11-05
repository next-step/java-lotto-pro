package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import lotto.domain.LottoNumbersFactory;

public class LottoNumbersFactoryTest {
    @DisplayName("로또 번호 생성 테스트 - 중복되지 않고 정렬된 6개의 숫자")
    @RepeatedTest(10)
    void lottoNumbersTest() {
        // when
        List<Integer> lottoNumbers = LottoNumbersFactory.createLottoNumbers();
        int lottoNumberSize = lottoNumbers.size();
        Set<Integer> duplicateNumbers = new HashSet<>(lottoNumbers);

        // then
        assertThat(lottoNumberSize).isEqualTo(6);
        assertEquals(lottoNumberSize, duplicateNumbers.size());
        assertThat(lottoNumbers).isSorted();
    }
}
