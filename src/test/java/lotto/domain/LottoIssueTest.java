package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssueTest {

    @Test
    public void 로또를_자동으로_5장_발급한다() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(5000);
        Map<Integer, List<Integer>> inputManualLottoNumbers = new TreeMap<>();

        //when
        LottoTicket lottoTicket = LottoIssue.of(lottoPurchase, inputManualLottoNumbers);

        //then
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(5);
    }

    @Test
    public void 로또를_수동으로_2장_자동으로_5장_발급한다() {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(7000);
        lottoPurchase.buyManualQuantity(2);
        Map<Integer, List<Integer>> inputManualLottoNumbers = new TreeMap<>();
        inputManualLottoNumbers.put(1, Arrays.asList(1, 2, 3, 4, 5, 6));
        inputManualLottoNumbers.put(2, Arrays.asList(11, 12, 13, 14, 15, 16));

        //when
        LottoTicket lottoTicket = LottoIssue.of(lottoPurchase, inputManualLottoNumbers);

        //then
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(7);
    }

}