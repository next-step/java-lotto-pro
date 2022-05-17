package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TicketTest {

    @ParameterizedTest
    @CsvSource(value = {"a:true", "1000:false", "999:true", "-1:true"}, delimiter = ':')
    public void testMakeTicket(String money, boolean isThrowable) {
        if(isThrowable){
            Assertions.assertThatThrownBy(
                () -> new Ticket(new Money(money))
            ).isInstanceOf(IllegalArgumentException.class);
        }else{
            Assertions.assertThat(new Ticket(new Money(money)))
                .isInstanceOf(Ticket.class);
        }
    }
}
