package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
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

    @DisplayName("로또 구매할 금액과 수동으로 적은 로또 list를 인자값으로 넣으면 발급한다.")
    @Test
    void issuedWithManualLottoTest() {
        Lotto manualLotto = new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6}));
        List<Lotto> lottoList = Collections.singletonList(manualLotto);
        LottoPaper paper = vendingMachine.issued(new LottoMoney(14000), lottoList);
        assertThat(paper.isContain(manualLotto)).isTrue();
    }

    @DisplayName("수동 로또가 비어있어나 없을경우에는 자동으로 발급된다.")
    @Test
    void 발급시수동로또가비어있거나없을경우() {
        assertThat(vendingMachine.issued(new LottoMoney(14000), null).numberOfPurchases()).isEqualTo(14);
        assertThat(vendingMachine.issued(new LottoMoney(14000), Collections.emptyList()).numberOfPurchases()).isEqualTo(14);
    }
}
