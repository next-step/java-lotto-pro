package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoVendingMachineTest {

    @DisplayName("1000원 단위로 Lotto 를 발급하고 LottoPaper 를 반환한다.")
    @Test
    void issuedTest() {
        LottoPaper lottoPaper = new LottoVendingMachine().issued(14000);
        assertThat(lottoPaper.isIssuedLottoCount(14)).isTrue();
    }
}
