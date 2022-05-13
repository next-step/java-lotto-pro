package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class LottoVendingMachineTest {
    private LottoGenerator generator = spy(new LottoGenerator());

    @DisplayName("1000원 단위로 Lotto 를 발급하고 LottoPaper 를 반환한다.")
    @Test
    void issuedTest() {
        new LottoVendingMachine(generator).issued(14000);
       verify(generator).auto(14);
    }
}
