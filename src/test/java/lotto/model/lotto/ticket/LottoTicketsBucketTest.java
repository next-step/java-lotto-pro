package lotto.model.lotto.ticket;

import lotto.constant.numbers.LottoConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsBucketTest {
    static class LottoTicketsBucketForTest extends LottoTicketsBucket {
        LottoTicketsBucketForTest(int howManyTickets) {
            super(howManyTickets);
        }

        int bucketSize() {
            return lottoTickets.size();
        }
    }

    @Nested
    @DisplayName("LottoTicketsBucket 생성자 테스트")
    class Constructor {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 13, 597, 2000})
        @DisplayName("LottoTicketsBucket 클래스 생성자 실행 결과, 생성자에 야규먼트로 전달한 개수 만큼 로또 티켓을 만든다")
        void constructor(int numberOfTickets) {
            final LottoTicketsBucketForTest lottoTicketsBucketForTest = new LottoTicketsBucketForTest(numberOfTickets);
            for (int i = 0; i < numberOfTickets; ++i) {
                final List<Integer> candidates = intsFromOneToFortyFive();
                final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
                lottoTicketsBucketForTest.addLottoTicket(new LottoTicket(lottoNumberGenerator));
            }
            assertThat(lottoTicketsBucketForTest.bucketSize()).isEqualTo(numberOfTickets);
        }

        private List<Integer> intsFromOneToFortyFive() {
            final List<Integer> fullCandidateList = new ArrayList<>(LottoConstant.LOTTO_MAXIMUM_NUMBER);
            for (int i = LottoConstant.LOTTO_MINIMUM_NUMBER; i <= LottoConstant.LOTTO_MAXIMUM_NUMBER; ++i) {
                fullCandidateList.add(i);
            }
            return fullCandidateList;
        }
    }

    @Nested
    @DisplayName("addLottoTicket 메서드 테스트")
    class AddLottoTicket {
        @Test
        @DisplayName("LottoTicket 객체 추가 성공")
        void success() {
            final int numberOfLottoTickets = 3;
            final LottoTicketsBucketForTest lottoTicketsBucketForTest = new LottoTicketsBucketForTest(0);
            for (int i = 0; i < numberOfLottoTickets; ++i) {
                final List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
                lottoTicketsBucketForTest.addLottoTicket(new LottoTicket(lottoNumberGenerator));
            }
            assertThat(lottoTicketsBucketForTest.bucketSize()).isEqualTo(numberOfLottoTickets);
        }
    }
}
