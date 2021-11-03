package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    @Test
    @DisplayName("6개의 로또 번호를 가진다.")
    void createLottoTicket() {
        //given //when
        LottoTicket lottoTicket = LottoTicket.from(1, 2, 3, 4, 5, 6);

        //then
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @ParameterizedTest(name = "로또 티켓 범위: [{index}] {0}")
    @ValueSource(ints = {5, 7})
    @DisplayName("로또 번호가 6개 보다 작거나 많은 경우 예외가 발생한다.")
    void validateSize(int size) {
        //given //when
        int[] numbers = IntStream.rangeClosed(1, size)
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.from(numbers));
    }

    @Test
    @DisplayName("로또 번호가 중복될 경우 예외가 발생한다.")
    void validateDuplication() {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.from(1, 2, 3, 4, 5, 5));
    }
}
