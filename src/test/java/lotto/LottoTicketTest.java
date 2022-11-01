package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> numbers;

    @BeforeEach
    void setUp() {
        numbers = pickUniqueLottoNumbers(LOTTO_SIZE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyLottoNumbers(final List<LottoNumber> invalidNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoTicket(invalidNumbers))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyNumbers(final int[] invalidNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoTicket.of(invalidNumbers))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 8, 9, 10})
    void invalidLottoNumberSize(final int size) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoTicket(pickUniqueLottoNumbers(size)))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void duplicatedLottoNumbers() {
        // make it duplicated
        numbers.set(0, numbers.get(1));

        assertThat(numbers.get(0)).isEqualTo(numbers.get(1));

        // shuffle and test
        for (int i = 0; i < numbers.size(); i++) {
            Collections.shuffle(numbers);

            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(numbers))
                .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
        }
    }

    @Test
    void validLottoNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            Collections.shuffle(numbers);

            assertThatCode(() -> new LottoTicket(numbers)).doesNotThrowAnyException();
        }
    }

    @Test
    void match_nothing() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(7, 8, 9, 10, 11, 12)))
            .isEqualTo(LottoMatchResult.NOTHING);
    }

    @Test
    void match_one() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(1, 7, 8, 9, 10, 11)))
            .isEqualTo(LottoMatchResult.ONE);
    }

    @Test
    void match_two() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(1, 2, 8, 9, 10, 11)))
            .isEqualTo(LottoMatchResult.TWO);
    }

    @Test
    void match_three() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(1, 2, 3, 9, 10, 11)))
            .isEqualTo(LottoMatchResult.THREE);
    }

    @Test
    void match_four() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(1, 2, 3, 4, 10, 11)))
            .isEqualTo(LottoMatchResult.FOUR);
    }

    @Test
    void match_five() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(1, 2, 3, 4, 5, 11)))
            .isEqualTo(LottoMatchResult.FIVE);
    }

    @Test
    void match_all() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6).matchTo(LottoTicket.of(1, 2, 3, 4, 5, 6)))
            .isEqualTo(LottoMatchResult.ALL);
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
