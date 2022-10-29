package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private static final int SIZE_OF_FULL_CANDIDATE_LIST = 45;

    static class LottoTicketForTest extends LottoTicket {
        public LottoTicketForTest(LottoNumberGenerator lottoNumberGenerator) {
            super(lottoNumberGenerator);
        }

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
        final List<Integer> candidates = intsFromOneToFortyFive();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
        final LottoTicketForTest lottoTicketForTest = new LottoTicketForTest(lottoNumberGenerator);
        final Set<Integer> numberSet = lottoTicketForTest.numberMadeSet();
        assertThat(numberSet.size()).isEqualTo(lottoTicketForTest.numbers().size());
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(SIZE_OF_FULL_CANDIDATE_LIST);
        for (int i = 1; i <= SIZE_OF_FULL_CANDIDATE_LIST; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }
}
