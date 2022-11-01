package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsBucketTest {
    static class LottoTicketsBucketForTest extends LottoTicketsBucket {
        public LottoTicketsBucketForTest(int howManyTickets) {
            super(howManyTickets);
        }

        int bucketSize() {
            return lottoTickets.size();
        }
    }

    @Nested
    @DisplayName("LottoTicketsBucket 생성자 테스트")
    class ConstructorInt {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 13, 597, 2000})
        @DisplayName("LottoTicketsBucket 클래스 생성자 실행 결과, 생성자에 야규먼트로 전달한 개수 만큼 로또 티켓을 만든다")
        void success(int numberOfTickets) {
            assertDoesNotThrow(() -> new LottoTicketsBucket(numberOfTickets));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -987654321, -771, -19, -2, -1})
        @DisplayName("LottoTicketsBucket 클래스 생성자 실행 결과, 생성자에 야규먼트로 전달한 개수 만큼 로또 티켓을 만든다")
        void errorInvalidNumberOfTickets(int numberOfTickets) {
            assertThrows(IllegalStateException.class, () -> new LottoTicketsBucket(numberOfTickets));
        }
    }

    @Nested
    @DisplayName("addLottoTicket 메서드 테스트")
    class AddLottoTicket {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 13, 597, 2000})
        @DisplayName("지정한 개수만큼 addLottoTicket 호출하면 lottoTickets 멤버 변수의 size 가 지정한 개수가 되어야 한다.")
        void success(int numberOfTickets) {
            final LottoTicketsBucketForTest lottoTicketsBucket = new LottoTicketsBucketForTest(numberOfTickets);
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            int numberCount = numberOfTickets;
            while (0 < numberCount) {
                lottoTicketsBucket.addLottoTicket(new LottoTicket(lottoNumberGenerator));
                numberCount = numberCount - 1;
            }
            assertThat(lottoTicketsBucket.bucketSize()).isEqualTo(numberOfTickets);
        }
    }
}
