package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호는 오름차순 정렬")
    @Test
    void lottoNumberAscSortTest() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generator();

        assertThat(lottoNumbers).isSorted();
    }
}
