package lotto.model.purchased;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.HashSet;
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
    @DisplayName("구입한 로또가 몇등인지 확인한다.")
    void 구입한_로또가_당첨인지_확인() {
        LottoNumbers lottoNumberSet = LottoNumbers.fromLottoNumberSet(
            generateLottoNumberList(new int[]{1, 2, 3, 4, 5, 6}));
        LottoNumbers winningNumberSet = LottoNumbers.fromLottoNumberSet(
            generateLottoNumberList(new int[]{1, 2, 3, 4, 5, 6}));

        PurchasedLotto purchasedLotto = new PurchasedLotto(lottoNumberSet, LottoGeneratorType.AUTO);

        assertThat(purchasedLotto.checkWinning(winningNumberSet).get()).isEqualTo(LottoWinningPriceType.SIX);
    }

    private Set<LottoNumber> generateLottoNumberList(int[] numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }


}
