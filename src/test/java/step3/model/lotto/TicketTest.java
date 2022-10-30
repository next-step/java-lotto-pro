package step3.model.lotto;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.model.machine.Result;
import step3.model.value.Rule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {
    private Lotto lotto;

    @BeforeEach
    void setup() {
        lotto = new Lotto("1,2,3,4,5,6");
    }
    @Test
    void 결과_테스트_성공() {
        Ticket ticket = new Ticket(Arrays.asList(1,2,3,4,5,6));
        assertThat(ticket.getResult(lotto)).isEqualTo(Result.FIRST_PRIZE);
    }
    @Test
    void 결과_테스트_실패() {
        Ticket ticket = new Ticket(Arrays.asList(7,8,9,10,11,12));
        assertThat(ticket.getResult(lotto)).isEqualTo(Result.NO_PRIZE);
    }
    @Test
    void 순서_바뀌어도_결과_같음() {
        Ticket ticket = new Ticket(Arrays.asList(1,2,3,4,5,6));
        Ticket ticket2 = new Ticket(Arrays.asList(6,5,4,3,2,1));
        assertThat(ticket.getResult(lotto)).isEqualTo(ticket2.getResult(lotto));
    }
}