package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoNumberShuffler 테스트")
class LottoNumberGeneratorTest {

    @Test
    @DisplayName("중복되지 않은 정렬된 로또 숫자를 생성한다.")
    void generate1() {
        // when
        List<Integer> numbers = LottoNumberGenerator.generate();

        // then
        assertAll(
                () -> assertThat(numbers.size()).isEqualTo(Lotto.LOTTO_NUMBERS_SIZE),
                () -> assertThat(getUniqueSize(numbers)).isEqualTo(Lotto.LOTTO_NUMBERS_SIZE),
                () -> assertThat(numbers).isEqualTo(getSortedList(numbers))
        );
    }

    @Test
    @DisplayName("생성할 때마다 다른 로또 숫자를 생성한다.")
    void generate2() {
        // when
        List<Integer> numbers1 = LottoNumberGenerator.generate();
        List<Integer> numbers2 = LottoNumberGenerator.generate();

        // then
        assertThat(numbers1).isNotEqualTo(numbers2);
    }

    private int getUniqueSize(List<Integer> numbers) {
        return new HashSet<>(numbers).size();
    }

    private List<Integer> getSortedList(List<Integer> numbers) {
        List<Integer> sortedList = numbers.subList(0, numbers.size());
        Collections.sort(sortedList);
        return sortedList;
    }
}
