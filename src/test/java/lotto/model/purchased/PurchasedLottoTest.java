package lotto.model.purchased;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.model.factory.LottoAutoFactory;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.type.LottoGeneratorType;
import lotto.type.LottoWinningPriceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class PurchasedLottoTest {

    @Test
    @DisplayName("로또가 자동일 경우 상태값이 AUTO인지 체크")
    void 자동일_경우_상태값_체크() {
        PurchasedLotto purchasedLotto = PurchasedLotto.createAuto();
        Assertions.assertEquals(purchasedLotto.getLottoGeneratorType(), LottoGeneratorType.AUTO);
    }

    @Test
    @DisplayName("구입한 로또가 몇등인지 확인한다.")
    void 구입한_로또가_당첨인지_확인() {
        Set<LottoNumber> lottoNumberList = generateLottoNumberList(new int[]{1, 2, 3, 4, 5, 6});
        Set<LottoNumber> winningNumberList = generateLottoNumberList(new int[]{1, 2, 3, 4, 5, 6});
        LottoNumbers winningNumbers = new LottoNumbers(winningNumberList);

        PurchasedLotto purchasedLotto = PurchasedLotto.createManual(new LottoNumbers(lottoNumberList));

        assertThat(purchasedLotto.checkWinning(winningNumbers).get()).isEqualTo(LottoWinningPriceType.SIX);
    }

    private Set<LottoNumber> generateLottoNumberList(int[] numbers) {
        Set<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }



}
