package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ShuffleTicketGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"5","6"})
    void 티켓_생성_갯수_테스트(int input) {
        TicketGenerator ticketGenerator = new ShuffleTicketGenerator();
        assertThat(ticketGenerator.generateTicket(input).size()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10","20","30"})
    void 중복_번호_생성되는지_검사(int input){
        TicketGenerator ticketGenerator = new ShuffleTicketGenerator();
        List<Integer> tickets = ticketGenerator.generateTicket(input);
        assertThat(tickets.size()).isEqualTo(new HashSet<>(tickets).size());
    }
}