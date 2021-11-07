package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoNumberShuffler 테스트")
class LottoGeneratorTest {

    @Test
    @DisplayName("중복되지 않은 정렬된 로또 숫자를 생성한다.")
    void generate() {
        // when
        Lotto lotto = LottoGenerator.generate();
        List<Integer> lottoNumbers = lotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        // then
        assertAll(
                () -> assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_NUMBERS_SIZE),
                () -> assertThat(getUniqueSize(lottoNumbers)).isEqualTo(Lotto.LOTTO_NUMBERS_SIZE),
                () -> assertThat(lottoNumbers).isEqualTo(getSortedList(lottoNumbers))
        );
    }

    private int getUniqueSize(List<Integer> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size();
    }

    private List<Integer> getSortedList(List<Integer> lottoNumbers) {
        List<Integer> sortedList = lottoNumbers.subList(0, lottoNumbers.size());
        Collections.sort(sortedList);
        return sortedList;
    }
}
