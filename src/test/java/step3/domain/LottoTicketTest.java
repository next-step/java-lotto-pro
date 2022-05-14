package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {


    @Test
    @DisplayName("String값들과 Int값들을 통해 ticket을 발행할때 검증")
    public void createLottoTicket() {
        //given
        List<String> 정상티켓 = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> 숫자5개티켓 = Arrays.asList("1", "2", "3", "4", "5");
        List<String> 음수티켓 = Arrays.asList("-1", "2", "3", "4", "5", "6");
        List<String> 문자티켓 = Arrays.asList("a", "2", "3", "4", "5", "6");
        //when
        assertAll(
            () -> assertThat(LottoTicket.create(정상티켓)).isNotInstanceOf(IllegalArgumentException.class).as("정상동작"),
            () -> assertThatThrownBy(() -> LottoTicket.create(숫자5개티켓)).isInstanceOf(IllegalArgumentException.class).as("Throw동작"),
            () -> assertThatThrownBy(() -> LottoTicket.create(음수티켓)).isInstanceOf(IllegalArgumentException.class).as("Throw동작"),
            () -> assertThatThrownBy(() -> LottoTicket.create(문자티켓)).isInstanceOf(IllegalArgumentException.class).as("Throw동작")
        );
    }
}
