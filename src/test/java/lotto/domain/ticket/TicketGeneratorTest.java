package lotto.domain.ticket;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TicketGeneratorTest {
    List<Ticket> tickets;

    @BeforeAll
    void setUp() {
        tickets = Arrays.asList(Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Ticket.from(Arrays.asList(1, 2, 3, 4, 5, 7)));
    }

    @DisplayName("티켓을 여러 개 생성하는 메서드에 원하는 개수를 인자로 받으면, 리스트 콜렉션 객체를 반환한다.")
    @Test()
    void generateTicketsTest() {
        assertThat(TicketGenerator.generateTickets(1)).isInstanceOf(List.class);
    }

    @DisplayName("티켓 콜렉션을 인자로 받아 lottoNumbersDtos 메서드를 호출하면, LottoNumbersDto 리스트 콜렉션 객체를 반환한다.")
    @Test()
    void lottoNumbersDtosTest() {
        assertThat(TicketGenerator.lottoNumbersDtos(tickets)).isInstanceOf(List.class);
    }
}
