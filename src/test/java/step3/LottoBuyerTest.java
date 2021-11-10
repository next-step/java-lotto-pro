package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    @DisplayName("지불금액 : 10000원 , 수동 2개, 자동 8개, 검증")
    void countOf_수동구매_자동구매_카운트() {
        // given
        Amount amount = new Amount(10000);
        LottoBuyer lottoBuyer = new LottoBuyer(amount);
        List<LottoNumbers> manualBundle = new ArrayList<>();
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
    @DisplayName("지불금액 : 5000 , 모두 자동구매 갯수 테스트")
    void countOf_모두_자동구매_카운트() {
        // given
        Amount amount = new Amount(5000);
        LottoBuyer lottoBuyer = new LottoBuyer(amount);

        // when
        lottoBuyer.autoBuyLotto();

        // then
        assertThat(lottoBuyer.countOf(BuyType.AUTO)).isEqualTo(5);
    }

    @Test
    void 구매_로또_출력시_정렬_확인() {
        // given
        List<Integer> buyNumbers = Arrays.asList(6, 2, 4, 1, 5, 3);
        Amount amount = new Amount(1000);
        LottoBuyer lottoBuyer = new LottoBuyer(amount);
        List<LottoNumbers> manualBundle = new ArrayList<>();
        manualBundle.add(LottoNumbersFactory.createManualLottoNumbers(buyNumbers));

        // when
        LottoNumbersBundle lottoNumbersBundle = LottoNumbersBundle.of(manualBundle);
        lottoBuyer.buyLotto(lottoNumbersBundle);

        // then
        Collections.sort(buyNumbers);
        assertThat(lottoBuyer.getLottoNumberList().get(0)).isEqualTo(buyNumbers.toString());
    }

}
