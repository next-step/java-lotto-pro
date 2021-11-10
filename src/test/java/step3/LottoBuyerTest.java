package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.Amount;
import step3.domain.BuyType;
import step3.domain.LottoBuyer;
import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.factory.LottoNumbersFactory;

public class LottoBuyerTest {

    @Test
    @DisplayName("지불금액 : 1000원 , 수동 2개, 자동 8개, 검증")
    void countOf_수동구매_자동굼_카운트() {
        // given
        List<LottoNumbers> manualBundle = new ArrayList<>();
        Amount amount = new Amount(10000);
        LottoBuyer lottoBuyer = new LottoBuyer(amount);
        manualBundle.add(LottoNumbersFactory.createManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        manualBundle.add(LottoNumbersFactory.createManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        LottoNumbersBundle lottoNumbersBundle2 = LottoNumbersBundle.of(manualBundle);

        // when
        lottoBuyer.buyLotto(lottoNumbersBundle2);
        lottoBuyer.autoBuyLotto();

        // then
        assertThat(lottoBuyer.countOf(BuyType.MANUAL)).isEqualTo(2);
        assertThat(lottoBuyer.countOf(BuyType.AUTO)).isEqualTo(8);
    }

    @Test
    @DisplayName("asd")
    void test() {
        // given
        List<LottoNumbers> manualBundle = new ArrayList<>();
        Amount amount = new Amount(10000);
        LottoBuyer lottoBuyer = new LottoBuyer(amount);
        manualBundle.add(LottoNumbersFactory.createManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        manualBundle.add(LottoNumbersFactory.createManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        LottoNumbersBundle lottoNumbersBundle2 = LottoNumbersBundle.of(manualBundle);

        // when
        lottoBuyer.buyLotto(lottoNumbersBundle2);
        lottoBuyer.autoBuyLotto();

        List<String> result = lottoBuyer.getLottoNumberList();
        for (String print : result) {
            System.out.println(print);
        }
    }

}
