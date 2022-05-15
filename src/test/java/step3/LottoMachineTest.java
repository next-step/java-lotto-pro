package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoManager;
import step3.model.LottoMachine;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        lottoMachine = new LottoMachine(new LottoManager());
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "999:null", "a:null", "-1:null"}, delimiter = ':', nullValues = {"null"})
    public void buyTicketTest(String money, String expected) {
        assertThat(lottoMachine.buyTicket(money)).isEqualTo(expected);
    }
}


