package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoManager;
import step3.domain.Money;
import step3.model.LottoMachine;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        lottoMachine = new LottoMachine(new LottoManager());
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1500:1", "3000:3", "10001:10"}, delimiter = ':')
    public void buyTicketTest(String money, int expected) {
        Money moneyEntity = new Money(money);
        assertThat(lottoMachine.buyTicket(moneyEntity)).isEqualTo(expected);
    }
}


