package lotto.domain.lotto;

import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseMoney;
import lotto.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketVendingMachineTest {

    @Test
    @DisplayName("자동 티켓 장수 만큼 자동으로 로또 티켓을 생성한다.")
    void autoIssueTickets() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(5000);
        int manualAmount = 0;
        PurchaseAmount purchaseAmount = purchaseMoney.getPurchaseAmount(manualAmount);
        LottoTicketVendingMachine vendingMachine = new LottoTicketVendingMachine();

        //when
        LottoTickets lottoTickets = vendingMachine.issueTickets(purchaseAmount.getAutoTicketAmount(), Collections.emptyList());

        //then
        assertThat(lottoTickets.getLottoTickets()).hasSize(5);
        assertThat(purchaseAmount.getManualTicketAmount()).isZero();
    }

    @Test
    @DisplayName("수동 티켓 장수 만큼 수동으로 로또 티켓을 생성한다.")
    void manualIssueTickets() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(5000);
        int manualAmount = 2;
        PurchaseAmount purchaseAmount = purchaseMoney.getPurchaseAmount(manualAmount);
        List<List<Integer>> manualNumbers = getManualNumbers();
        LottoTicketVendingMachine vendingMachine = new LottoTicketVendingMachine();

        //when
        LottoTickets lottoTickets = vendingMachine.issueTickets(purchaseAmount.getAutoTicketAmount(), manualNumbers);

        //then
        assertThat(lottoTickets.getLottoTickets()).hasSize(5);
        assertThat(purchaseAmount.getManualTicketAmount()).isEqualTo(manualAmount);
    }

    private List<List<Integer>> getManualNumbers() {
        List<String> inputManualLottoNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 15, 16");

        return inputManualLottoNumbers.stream()
                .map(StringUtil::splitParseInt)
                .collect(Collectors.toList());
    }
}