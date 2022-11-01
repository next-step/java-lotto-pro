package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyLottoNumbers(final List<LottoNumber> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(numbers))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9, 10})
    void invalidLottoNumberSize(final int size) {
        final List<LottoNumber> numbers = pickUniqueLottoNumbers(size);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(numbers))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void duplicatedLottoNumbers() {
        final List<LottoNumber> numbers = pickUniqueLottoNumbers(LOTTO_SIZE);

        // make it duplicated
        numbers.set(0, numbers.get(1));

        assertThat(numbers.get(0)).isEqualTo(numbers.get(1));

        // shuffle and test
        for (int i = 0; i < numbers.size(); i++) {
            Collections.shuffle(numbers);

            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
        }
    }

    @Test
    void validLottoNumbers() {
        final List<LottoNumber> numbers = pickUniqueLottoNumbers(LOTTO_SIZE);

        for (int i = 0; i < numbers.size(); i++) {
            Collections.shuffle(numbers);

            assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
        }
    }
   
    private static List<LottoNumber> pickUniqueLottoNumbers(final int count) {
        return mapToLottoNumberList(
            RandomUtils.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, count));
    }

    private static List<LottoNumber> mapToLottoNumberList(final List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList());
    }

}
