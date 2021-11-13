package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    List<Number> numbers = new ArrayList<>();
    LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= LottoTicket.LOTTO_NUMBER_COUNT; i++) {
            numbers.add(new Number(i));
        }
        lottoTicket = new LottoTicket(numbers);
    }

    @Test
    void 로또_티켓_생성() {
        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket).isNotNull();
    }

    @Test
    void 로또_티켓_생성_정적_팩터리_메서드() {
        // when
        LottoTicket result = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(result).isEqualTo(lottoTicket);
    }

    @Test
    void 로또_티켓_생성_갯수_안맞는_경우() {
        // given
        numbers = new ArrayList<>();

        // when, then
        assertThatThrownBy(() -> new LottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + LottoTicket.LOTTO_NUMBER_COUNT + "개가 존재해야 합니다. (입력값: " + numbers.size() + ")");
    }

    @Test
    void 로또_티켓_생성_중복() {
        // given
        int duplicatedNumber = 1;
        numbers = new ArrayList<>();
        for (int i = 1; i <= LottoTicket.LOTTO_NUMBER_COUNT; i++) {
            numbers.add(new Number(duplicatedNumber));
        }

        // when, throw
        assertThatThrownBy(() -> new LottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + duplicatedNumber + ")");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void 숫자_포함하는지_검사(int inputNumber, boolean expectResult) {
        // when
        boolean result = lottoTicket.isContainNumber(new Number(inputNumber));

        // then
        assertThat(result).isEqualTo(expectResult);
    }
}