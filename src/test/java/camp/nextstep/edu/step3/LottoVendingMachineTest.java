package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoVendingMachineTest {

    private LottoVendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new LottoVendingMachine(new LottoGenerator());
    }

    @DisplayName("1000원 단위로 Lotto 를 발급하고 LottoPaper 를 반환한다.")
    @Test
    void issuedTest() {
        LottoPaper paper = vendingMachine.issued(new LottoMoney(14000));
        assertThat(paper.numberOfPurchases()).isEqualTo(14);
    }
}
