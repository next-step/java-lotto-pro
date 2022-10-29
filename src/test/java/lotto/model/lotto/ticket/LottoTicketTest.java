package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    static class LottoTicketForTest extends LottoTicket {
        Set<Integer> numberMadeSet() {
            return new HashSet<>(numbers);
        }

        List<Integer> numbers() {
            return numbers;
        }
    }

    @RepeatedTest(value = 100)
    @DisplayName("한 장의 로또에 있는 숫자는 총 6개이고, 어떤 숫자도 서로 중복이 없다")
    void constructor() {
        final LottoTicketForTest lottoTicketForTest = new LottoTicketForTest();
        Set<Integer> numberSet = lottoTicketForTest.numberMadeSet();
        assertThat(numberSet.size()).isEqualTo(lottoTicketForTest.numbers.size());
    }
}
